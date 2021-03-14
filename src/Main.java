import java.time.LocalDateTime;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {


        Customer.listCustomer.put("Alex", new Customer("Alex", "qwerty", 7000));
        Customer.listCustomer.put("Alena", new Customer("Alena", "1234", 5000));
        Customer.listCustomer.put("roman111", new Customer("roman111", "1111", 7000));
        Customer.listCustomer.put("valia999", new Customer("valia999", "777", 8600));
        Customer.listCustomer.put("Dandy1", new Customer("Dandy1", "GG33", 7500));

        StartMenu.start();

        Product.listOfProduct.add(0, new Product(UUID.randomUUID(), "HP_Notebook", ModelOfProduct.ENVY_15_as006ur, LocalDateTime.of(2020, 10, 15, 15, 0)));
        Product.listOfProduct.add(1, new Product(UUID.randomUUID(), "HP_Notebook", ModelOfProduct.EliteBook_1030, LocalDateTime.of(2019, 5, 10, 17, 30)));
        Product.listOfProduct.add(2, new Product(UUID.randomUUID(), "HP_Notebook", ModelOfProduct.Elite_book_folio_g1, LocalDateTime.of(2015, 12, 28, 14, 25)));
        Product.listOfProduct.add(3, new Product(UUID.randomUUID(), "HP_Notebook", ModelOfProduct.Notebook_17_x013ur, LocalDateTime.of(2016, 11, 10, 21, 10)));
        Product.listOfProduct.add(4, new Product(UUID.randomUUID(), "HP_Notebook", ModelOfProduct.EliteBook_840_G1, LocalDateTime.of(2018, 4, 22, 8, 15)));
        Product.listOfProduct.add(5, new Product(UUID.randomUUID(), "HP_Notebook", ModelOfProduct.Envy_6, LocalDateTime.of(2014, 10, 3, 9, 11)));
        Product.listOfProduct.add(6, new Product(UUID.randomUUID(), "HP_Notebook", ModelOfProduct.OMEN_17_w211ur, LocalDateTime.of(2016, 11, 22, 10, 50)));
        Product.listOfProduct.add(7, new Product(UUID.randomUUID(), "HP_Notebook", ModelOfProduct.Pavilion_17_ab020ur, LocalDateTime.of(2017, 9, 3, 10, 0)));
        Product.listOfProduct.add(8, new Product(UUID.randomUUID(), "HP_Notebook", ModelOfProduct.Pavilion_dv6_6c60er_LinenWhite, LocalDateTime.of(2018, 8, 5, 11, 15)));
        Product.listOfProduct.add(9, new Product(UUID.randomUUID(), "HP_Notebook", ModelOfProduct.Pavilion_DV7_6053er, LocalDateTime.of(2019, 5, 25, 14, 20)));
        Product.listOfProduct.add(10, new Product(UUID.randomUUID(), "HP_Notebook", ModelOfProduct.Pavilion_X2, LocalDateTime.of(2020, 7, 25, 12, 30)));
        Product.listOfProduct.add(11, new Product(UUID.randomUUID(), "HP_Notebook", ModelOfProduct.Pavilion_x360_11, LocalDateTime.of(2018, 5, 12, 8, 30)));
        Product.listOfProduct.add(12, new Product(UUID.randomUUID(), "HP_Notebook", ModelOfProduct.Probook_450_g3, LocalDateTime.of(2016, 12, 10, 10, 15)));
        Product.listOfProduct.add(13, new Product(UUID.randomUUID(), "HP_Notebook", ModelOfProduct.ProBook_4530s, LocalDateTime.of(2017, 8, 20, 11, 15)));
        Product.listOfProduct.add(14, new Product(UUID.randomUUID(), "HP_Notebook", ModelOfProduct.Spectre_13_v103ur, LocalDateTime.of(2019, 8, 10, 5, 0)));
        Product.listOfProduct.add(15, new Product(UUID.randomUUID(), "HP_Notebook", ModelOfProduct.ProBook_655_G3, LocalDateTime.of(2020, 1, 1, 15, 0)));

        Product products = new Product(Product.listOfProduct);

        products.menu();

        Customer.readListOfCustomer();


    }

}

