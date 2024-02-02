import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Initializer {
    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
        customer.setId(001);
        customer.setName("Amal");
        customer.setAddress("Galle");
        customer.setSalary(45550.00);

        session.save(customer);
        transaction.commit();
        session.close();
    }
}