package com.edu.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2. Написать программу, выполняющую поиск в строке
 * шестнадцатиричных чисел, запианных по правилам Java,
 * с помощью регулярных выражений и выводящую их на страницу.
 */
public class Task2 {
    public static void main(String[] args) {
        String regex = "0[xX][0-9a-fA-F]+";
        String input = "sfdsf 0xff sffaf 0x12 adffs 0XAB";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
