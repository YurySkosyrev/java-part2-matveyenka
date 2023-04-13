package com.edu.regex;

import java.util.regex.Pattern;

/**
 * 1. Написать программу, провеыряющую, является ли введенная
 * строка адресом почтового ящика.
 * В названии почтового ящика разрешить использование только
 * букв, цифр и нижних подчёркиваний, при этом она должна
 * начинаться с буквы.
 * Возможные домены верхнего уровня: .org .com
 */
public class Task1 {
    public static void main(String[] args) {
        String regex = "[a-zA_Z]\\w*@\\w{3,}\\.(org|com)";
        String input = "1urez@mail.org";
        System.out.println(Pattern.matches(regex, input));
    }
}
