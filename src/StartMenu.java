import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class StartMenu extends Customer {


    public static String key;

    public StartMenu(Map<String, Customer> listCustomer) {
        Customer.listCustomer = listCustomer;
    }


    public static void printMenu() {
        System.out.println("1. Просматреть список товаров с их ID для покупки");
        System.out.println("2. Купить товар");
        System.out.println("3. Просматреть купленные товары");
        System.out.println("4. Выход из приложения");
    }

    public static void addNewCustomer(String newLogin, Customer newCustomer) {

        listCustomer.put(newLogin, newCustomer);
    }

    public static void start() {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter your Login:");
            String login = sc.next();
            System.out.println("Enter your password:");
            String password = sc.next();
            File file = new File("UsersLoginPassword.txt");

            Scanner sc1 = new Scanner(file);

            while (sc1.hasNextLine()) {
                String line1 = sc1.nextLine();

                if (line1.equals("Login - " + login + "  " + "password - " + password)) {
                    System.out.println("Логин и пароль введены верно");
                    System.out.println();
                    System.out.println("Выберите один из пунктов меню: ");
                    System.out.println();
                    key = login;
                    printMenu();
                    return;
                }
            }
        } catch (InputMismatchException | FileNotFoundException ex1) {
            System.out.println(ex1.getMessage());
        }
        System.out.println("Введены не существующие Login/Password");
        System.out.println("Хотите создать нового пользователя?");
        System.out.println("\nВведите yes/no:");
        try {
            Scanner sc2 = new Scanner(System.in);
            String answer = sc2.next();
            if (answer.equals("no")) {
                System.out.println("Введите 5 для выхода :");
                return;
            }
            if (answer.equals("yes")) {
                System.out.println("\nВведите свой логин:");
                String newLogin = sc2.next();
                System.out.println("Введите пароль:");
                String newPassword = sc2.next();

                System.out.println("Введите сумму денег на вашем электронном счету, открыв к нему доступ для списания средств:");
                int cashNewCustomer = sc2.nextInt();
                try (FileWriter loginPassword = new FileWriter("UsersLoginPassword.txt", true)) {
                    loginPassword.write("Login - " + newLogin + "  " + "password - " + newPassword + "\n");
                    Customer newCustomer = new Customer(newLogin, newPassword, cashNewCustomer);
                    addNewCustomer(newLogin, newCustomer);
                    key = newLogin;
                    System.out.println("\nДобавлен новый пользователь");
                    System.out.println("Добро пожаловать " + newLogin + " !!!" + " Выберете один из пунктов меню:\n");
                    printMenu();

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                try (FileWriter fileOfCustomer = new FileWriter(newLogin + "FileOfCustomer.txt", true)) {
                    fileOfCustomer.write("купленные товары:\n");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        } finally {
            System.out.println("_______");
        }

    }
}
