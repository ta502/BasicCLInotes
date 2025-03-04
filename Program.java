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
                System.out.println("5. ABOUT");
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
                    case 5 -> {
                        System.out.println("BasicCLInotes IS A BARE-BONES COMMAND LINE NOTE-TAKING PROGRAM.");
                        System.out.println("THIS SOFTWARE IS RELEASED UNDER NO LICENSE.");
                        System.out.println("VERSION 1.0");
                        System.out.println("Made by @ta502 (Talal)");
                    }
                    default -> throw new InputMismatchException();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("ERROR: NOT VALID");
        } catch (IOException er) {
            System.out.println("ERROR: IO ERROR");
        }
    }
}