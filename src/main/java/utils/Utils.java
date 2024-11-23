package utils;

import java.util.*;

import java.text.*;

public class Utils {

    private static Scanner sc = new Scanner(System.in);

    public static int getIntInput(String prompt) {

        int val;

        while (true) {

            try {

                System.out.print(prompt);

                val = Integer.parseInt(sc.nextLine());

                break;

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter an integer.");

            }

        }

        return val;

    }

    public static long getLongInput(String prompt) {

        long val;

        while (true) {

            try {

                System.out.print(prompt);

                val = Long.parseLong(sc.nextLine());

                break;

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter a valid number.");

            }

        }

        return val;

    }

    public static double getDoubleInput(String prompt) {

        double val;

        while (true) {

            try {

                System.out.print(prompt);

                val = Double.parseDouble(sc.nextLine());

                break;

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter a valid number.");

            }

        }

        return val;

    }

    public static String getStringInput(String prompt) {

        System.out.print(prompt);

        return sc.nextLine();

    }

    public static Date getDateInput(String prompt) {

        Date date = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        while (true) {

            try {

                System.out.print(prompt + " (dd-MM-yyyy): ");

                String input = sc.nextLine();

                date = sdf.parse(input);

                break;

            } catch (Exception e) {

                System.out.println("Invalid date format. Please enter again.");

            }

        }

        return date;

    }

}
