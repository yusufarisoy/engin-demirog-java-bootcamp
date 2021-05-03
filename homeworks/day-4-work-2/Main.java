import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapter;
import Concrete.CustomerCheckManager;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main
{
    public static void main(String[] args)
    {
        Customer customer1 = new Customer(1, "28861499482", 1996, "Engin", "Demiroğ");
        Customer customer2 = new Customer(2, "88547211453", 2000, "Yusuf Gökmen", "Arısoy");

        BaseCustomerManager neroCustomerManager = new NeroCustomerManager();
        neroCustomerManager.save(customer2);

        BaseCustomerManager starbucksCustomerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
        starbucksCustomerManager.save(customer1);
    }
}
