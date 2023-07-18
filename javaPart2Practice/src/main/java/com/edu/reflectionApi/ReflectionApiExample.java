package com.edu.reflectionApi;

import java.lang.reflect.*;

public class ReflectionApiExample {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        User user = new User(25L, "Ivan", 20);
//        Class<? extends User> userClass = user.getClass();
//        Class<User> userClass1 = User.class;
//        System.out.println(userClass == userClass1);
//        testConstructor();
//      testObjectFields(user);
        testSetMethods(user);
    }

    // Получение конструктора класса и создание новых объектов
    private static void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<User> constructor = User.class.getConstructor(Long.class, String.class);
        User petr = constructor.newInstance(5L, "Petr");
        System.out.println(petr);
    }

    // Получение полей по экземпляру класса
    private static void testFields(User user) throws IllegalAccessException {
        Field[] declaredFields = User.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true); // чтобы можно было достучаться до private полей.
            Object value = declaredField.get(user);
            System.out.println(value);
        }
    }

    // Получение полей класса Object
    private static void testObjectFields(Object object) throws IllegalAccessException {
        Field[] declaredFields = object.getClass().getSuperclass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object value = declaredField.get(object);
            System.out.println(declaredField.getModifiers());
            // [0, 0, 0, 0, 0, 1, 1] - маска для модификаторов Final, Public, Private
            System.out.println(Modifier.isPrivate(declaredField.getModifiers()));
            System.out.println(value);
        }
    }

    private static void testGetMethods(User user) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        user.getClass().getDeclaredMethods(); //получить свои методы

        Method method = user.getClass().getDeclaredMethod("getName");
        System.out.println(method.invoke(user)); // вызвать полученный метод у объекта user
        // в фреймворках обычно есть класс, который оборачивает такие методы и вызывает исключения
    }

    private static void testSetMethods(User user) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = user.getClass().getDeclaredMethod("setName", String.class);
        method.invoke(user, "Sveta");
        System.out.println(user);
    }
}
