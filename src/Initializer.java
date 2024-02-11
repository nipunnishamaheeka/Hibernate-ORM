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
        customer.setMobileNumber(07624112554);

        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        //session.close();


        //Get
        System.out.println("=====================Get======================");
        Customer extstingCustomer = session.get(Customer.class, 1);
        System.out.println("ExistingCustomer"+extstingCustomer);


//Update
        System.out.println("=====================Update======================");
        Transaction updateTransaction = session.beginTransaction();

        extstingCustomer.setName("A");

        session.update(extstingCustomer);

        updateTransaction.commit();
        System.out.println(extstingCustomer);

    //Delete
        System.out.println("=====================Delete======================");
        Transaction deleteTransaction = session.beginTransaction();

        Customer customerDel = session.get(Customer.class,1);

        session.delete(customerDel);

        deleteTransaction.commit();
        System.out.println(customerDel);

    }


}