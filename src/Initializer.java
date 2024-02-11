import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Initializer {
    public static void main(String[] args) {

        //Save
        Session session = SessionFactoryConfig
                .getInstance()
                .getSession();
        Customer customer = new Customer();

        customer.setId(1 );
        customer.setName("Rithik");
        customer.setAddress("Kandy");
        customer.setSalary(25550.00);

        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        //session.close();


        //Get

        Customer extstingCustomer = session.get(Customer.class, 1);


//Update

        //Session updateSession = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction1 = session.beginTransaction();

        extstingCustomer.setName("A");

        session.update(extstingCustomer);

        transaction1.commit();
        System.out.println(extstingCustomer);

    //Delete

        Transaction Deletetransaction = session.beginTransaction();

        Customer customerDel = session.get(Customer.class,1);

        session.delete(customerDel);

        Deletetransaction.commit();
       // System.out.println(extstingCustomer);

    }

//    private static Customer getCustomer() {
//        Customer customer = new Customer();
//        customer.setId(003);
//        customer.setName("Rithik");
//        customer.setAddress("Kandy");
//        customer.setSalary(25550.00);
//        return customer;
//    }
}