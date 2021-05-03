package Adapters;

import Abstract.CustomerCheckService;
import Entities.Customer;

public class MernisServiceAdapter implements CustomerCheckService
{
    @Override
    public boolean checkIfRealPerson(Customer customer)
    {
        //New Mernis Client
        return customer.getNationalityId().length() == 11;
    }
}
