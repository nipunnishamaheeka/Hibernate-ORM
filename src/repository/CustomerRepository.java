package repository;

import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

public class CustomerRepository {
    private final Session session;
    public CustomerRepository(){
         session = SessionFactoryConfig.getInstance().getSession();
    }

    public int saveCustomer(Customer customer){

        //Customer customer = new Customer();
        Transaction transaction = session.beginTransaction();

        try {

            int customerId = (int) session.save(customer);
            transaction.commit();
            session.close();
            return customerId;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();

           // throw new RuntimeException();  get to know the error front end side and handle it
            return -1;
        }
    }

    public  Customer getCustomer(int id){
        try {
            Customer customer = session.get(Customer.class, id);
            session.close();
            return customer;

        }   catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

}
