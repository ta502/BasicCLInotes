import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("    ____  ___   _____ __________     ________    ____     _   ______  _________________");
            System.out.println("   / __ )/   | / ___//  _/ ____/    / ____/ /   /  _/    / | / / __ \\/_  __/ ____/ ___/");
            System.out.println("  / __  / /| | \\__ \\ / // /  ______/ /   / /    / /_____/  |/ / / / / / / / __/  \\__ \\ ");
            System.out.println(" / /_/ / ___ |___/ // // /__/_____/ /___/ /____/ /_____/ /|  / /_/ / / / / /___ ___/ / ");
            System.out.println("/_____/_/  |_/____/___/\\____/     \\____/_____/___/    /_/ |_/\\____/ /_/ /_____//____/  ");
            System.out.println("WELCOME TO BASIC-CLI-NOTES");
            while (true) { 
                System.out.println("What do you want to do?");
                System.out.println("1. VIEW NOTES");
                System.out.println("2. ADD A NOTE");
                System.out.println("3. REMOVE A NOTE");
                System.out.println("4. EXIT");
                int user_input = scan.nextInt();
                switch (user_input) {
                    case 1 -> {
                        
                    }
                    default -> {
                        throw new InputMismatchException();
                    }    
                }
            }
        }
    }
}