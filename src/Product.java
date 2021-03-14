import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Product extends Customer {


    public static List<Product> listOfProduct = new ArrayList<>();
    private static int cashRegister = 1000;
    List<Product> purchaseList = new ArrayList<>();
    private UUID id;
    private String productName;
    private ModelOfProduct modelOfProduct;
    private LocalDateTime dateOfManufacture;

    public Product(List<Product> listOfProduct) {
        Product.listOfProduct = listOfProduct;
    }


    public Product() {
    }

    public Product(UUID id, String productName, ModelOfProduct modelOfProduct, LocalDateTime dateOfManufacture) {
        this.id = id;
        this.productName = productName;
        this.modelOfProduct = modelOfProduct;
        this.dateOfManufacture = dateOfManufacture;

    }

    public static void printMenu() {
        System.out.println("1. Просматреть список товаров с их ID для покупки");
        System.out.println("2. Купить товар");
        System.out.println("3. Просматреть купленные товары");
        System.out.println("4. Выход из приложения");
    }

    public void addPurchasedProductsInTextFile() {

    }

    public void readListOfProduct() {

        for (int j = 0; j < listOfProduct.size(); j++) {
            System.out.println(j + "." + listOfProduct.get(j));
        }

    }

    public List<Product> getListOfProduct() {
        return listOfProduct;
    }

    public void purchasedProducts() {

        Iterator<Product> iterator = purchaseList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void purchaseHPnotebook() throws NotEnoughMoneyException {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nВведите номер товара в списке,который хотите купить:");
            int numberOfProduct = sc.nextInt();

            System.out.println("Внесите необходимую сумму денег:");
            int money = sc.nextInt();

            System.out.println("_______");
            if (money < listOfProduct.get(numberOfProduct).modelOfProduct.getPrice()) {

                throw new NotEnoughMoneyException("Внесенной суммы денег не достаточно для покупки");

            }

            if (money == listOfProduct.get(numberOfProduct).modelOfProduct.getPrice()) {
                int newCashOfTheCustomer = listCustomer.get(StartMenu.key).getCash() - money;
                listCustomer.get(StartMenu.key).setCash(newCashOfTheCustomer);
                if (newCashOfTheCustomer < 0) {
                    System.out.println("У вас недостаточно денег для покупки данной модели");
                    return;
                }
                try (FileWriter fileOfCustomer = new FileWriter(StartMenu.key + "FileOfCustomer.txt", true)) {
                    fileOfCustomer.write("\n" + listOfProduct.get(numberOfProduct).toString());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

                purchaseList.add(listOfProduct.get(numberOfProduct));
                listOfProduct.remove(numberOfProduct);
                cashRegister += money;


                System.out.println("Список оставшихся товаров :");
                for (int j = 0; j < listOfProduct.size(); j++) {
                    System.out.println(j + "." + listOfProduct.get(j));
                }
                System.out.println();
                System.out.println("NoteBook под номером " + numberOfProduct + " был продан.");
                System.out.println();
                System.out.println("Касса пополнилась на  - " + money + " общая сумма денег в кассе - " + cashRegister);
                printMenu();

                System.out.println();

            }

            if (money > (listOfProduct.get(numberOfProduct).modelOfProduct.getPrice())) {
                System.out.println();
                int newCashOfTheCustomer = listCustomer.get(StartMenu.key).getCash() - money;
                if (newCashOfTheCustomer < 0) {
                    System.out.println("У вас не достаточно денег");
                    return;
                }
                int change = money - listOfProduct.get(numberOfProduct).modelOfProduct.getPrice();
                int newCashOfTheCustomer1 = money - change;
                listCustomer.get(StartMenu.key).setCash(newCashOfTheCustomer1);

                int a = money - change;
                cashRegister += a;
                listOfProduct.remove(numberOfProduct);
                try (FileWriter fileOfCustomer = new FileWriter(StartMenu.key + "FileOfCustomer.txt", true)) {
                    fileOfCustomer.write("\n" + listOfProduct.get(numberOfProduct).toString());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Список оставшихся товаров :");
                for (int j = 0; j < listOfProduct.size(); j++) {
                    System.out.println(j + "." + listOfProduct.get(j));
                }
                System.out.println("NoteBook под номером " + numberOfProduct + " был продан.");
                System.out.println("Количество денег в кассе увеличилось на " + a + " и суммарно составляет - " + cashRegister);
                System.out.println("Сдача составила - " + change);
                System.out.println();
                printMenu();
            }


        } catch (IndexOutOfBoundsException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void menu() {
        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s = "";


        while (!"4".equals(s)) {
            s = scan.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }

            switch (x) {
                case 1:
                    readListOfProduct();
                    System.out.println();
                    printMenu();

                    break;
                case 2:
                    try {
                        purchaseHPnotebook();
                    } catch (NotEnoughMoneyException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    purchasedProducts();
                    break;
            }
        }
        System.out.println("До свидания!");
    }


    @Override
    public String toString() {
        return "Product" +
                " id: " + id + "\n (name " + productName + ", " + modelOfProduct + ", dateOfManufacture: " + dateOfManufacture +
                ')';
    }

}