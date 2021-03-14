import java.util.HashMap;
import java.util.Map;

public class Customer {

    public static Map<String, Customer> listCustomer = new HashMap<>();
    private String login;
    private String password;
    private int cash;

    public Customer() {
    }

    public Customer(String login, String password, int cash) {
        this.login = login;
        this.password = password;
        this.cash = cash;

    }

    public Customer(Map<String, Customer> listCustomer) {
        Customer.listCustomer = listCustomer;
    }

    public static void readListOfCustomer() {
        for (Map.Entry<String, Customer> listUsers : listCustomer.entrySet())
            System.out.println(listUsers.getKey() + " - " + listUsers.getValue());
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", cash=" + cash +
                '}';
    }
}


//}
