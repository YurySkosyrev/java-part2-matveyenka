package com.edu.regex;

/**
 * 3. Написать программу, выполняющую поиск в строке всех тегов
 * абзацев, в т.ч. тех, у которых есть параметры, например
 * <p id="p1">,
 * и замены их на простые теги абзацев <p>.
 */
public class Task3 {
    public static void main(String[] args) {
        String regex = "(<p .+?>)(.+?</p>)";
        String input = "<p>sffdfdfd</p> <b>fsgfsgf</b> " +
                "<p id=\"p1\">dsfgsgdg</p> " +
                "safdsagfasg <p>sdafdsfas";
        System.out.println(input.replaceAll(regex, "<p>$2"));
    }
}
