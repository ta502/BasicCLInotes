import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            Properties notes = new Properties();
            System.out
                    .println("    ____  ___   _____ __________     ________    ____     _   ______  _________________");
            System.out.println(
                    "   / __ )/   | / ___//  _/ ____/    / ____/ /   /  _/    / | / / __ \\/_  __/ ____/ ___/");
            System.out.println(
                    "  / __  / /| | \\__ \\ / // /  ______/ /   / /    / /_____/  |/ / / / / / / / __/  \\__ \\ ");
            System.out
                    .println(" / /_/ / ___ |___/ // // /__/_____/ /___/ /____/ /_____/ /|  / /_/ / / / / /___ ___/ / ");
            System.out.println(
                    "/_____/_/  |_/____/___/\\____/     \\____/_____/___/    /_/ |_/\\____/ /_/ /_____//____/  ");
            System.out.println("WELCOME TO BASIC-CLI-NOTES");

            String FilePath = "notes.properties";

            while (true) {
                try (FileInputStream fw = new FileInputStream(FilePath)) {
                    notes.load(fw);
                }
                System.out.println("What do you want to do?");
                System.out.println("1. VIEW NOTES");
                System.out.println("2. ADD A NOTE");
                System.out.println("3. REMOVE A NOTE");
                System.out.println("4. EXIT");
                int user_input = scan.nextInt();
                switch (user_input) {
                    case 1 -> {
                        System.out.println("STORED NOTES:");
                        notes.forEach((key, value) -> System.out.println(key + " = " + value));
                    }
                    case 2 -> {
                        System.out.println("NAME OF THE NOTE:");
                        String user_input_2 = scan.next();
                        System.out.println("CONTENT OF NOTE:");
                        String user_input_3 = scan.next();
                        notes.setProperty(user_input_2, user_input_3);
                        try (FileOutputStream fo = new FileOutputStream(FilePath)) {
                            notes.store(fo, null);
                        }
                        System.out.println("INFO: NOTE CREATED SUCCESSFULLY");
                    }

                    case 3 -> {
                        System.out.println("NAME OF THE NOTE YOU WANT TO DELETE:");
                        String user_input_2 = scan.next();
                        if (notes.containsKey(user_input_2)) {
                            notes.remove(user_input_2);

                            try (FileOutputStream fo = new FileOutputStream(FilePath)) {
                                notes.store(fo, null);
                            }
                            System.out.println("INFO: NOTE DELETED SUCCESSFULLY");
                        } else {
                            System.out.println("ERROR: NOTE DOESN'T EXIST");
                        }
                    }
                    case 4 -> {
                        System.out.println("INFO: EXIT");
                        System.exit(0);
                    }
                    default -> {
                        throw new InputMismatchException();
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("ERROR: NOT VALID");
        } catch (IOException er) {
            System.out.println("ERROR: IO ERROR");
        }
    }
}