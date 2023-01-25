package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    // Метод, который выводит сообщения в консоль
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    // Прочитать строку с консоли
    public static String readString() throws IOException {
        String text = bis.readLine();
        return text;
    }

    // Прочитать число с консоли
    public static int readInt() throws IOException {
        String text = readString();
        return Integer.parseInt(text.trim());
    }
}
