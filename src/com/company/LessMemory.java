package com.company;

import java.util.Arrays;
import java.util.Random;

public class LessMemory {
    // если мы хотим занять как можно меньше памяти

    static final String nums = "0123456789";
    static final String abc = "qwertyuiopasdfghjklzxcvbnm";

    public static void main(String[] args) {

        long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Память до рандомных объектов: " + memoryBefore);

        int n = 18758328;
        User[] dataArray = new User[n];


        long start = System.currentTimeMillis();

        createUsers(n, dataArray);

        long createUsersTime = System.currentTimeMillis();
        System.out.println("Время на создание пользователей: " + (createUsersTime - start) / 1000.0);

        Arrays.sort(dataArray);

        long autosortTime = System.currentTimeMillis();
        System.out.println("Время на сортировку: " + (autosortTime - createUsersTime) / 1000.0);
        findUsers(dataArray);

        long end = System.currentTimeMillis();
        System.out.println("Время на поиск пользователей: " + (end - autosortTime) / 1000.0);

        long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("Память после: " + memoryAfter);
        System.out.println("Разность памяти до и после: " + 1.0 * (memoryAfter - memoryBefore) / (1024 * 1024 * 1024));

    }

    public static void printUsers(int n, User[] dataArray) {
        for (int i = 0; i < n; i++) {
            System.out.println(dataArray[i]);
        }
    }

    public static void createUsers(int n, User[] dataArray) {

        for (int i = 0; i < n; i++) {
            long phoneValue = Long.parseLong(createString(7, nums));
            String nameValue = createString(20, abc);
            dataArray[i] = new User(phoneValue, nameValue);
        }
    }

    public static String createString(int n, String str) {
        Random rnd = new Random();
        String result = "";

        for (int i = 0; i < n; i++) {
            int index = Math.abs(rnd.nextInt(str.length()));
            result += str.charAt(index);
        }
        return result;
    }

    public static void findUsers(User[] dataArray) {

        for (int i = 0; i < 30000000; i++) {
            long number = Long.parseLong(createString(7, nums));
            if (number == 0) {
                break;
            }
            int index = Arrays.binarySearch(dataArray, new User(number, ""));
        }
    }
}
