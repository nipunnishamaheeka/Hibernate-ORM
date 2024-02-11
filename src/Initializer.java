import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Initializer {
    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
        customer.setId(003);
        customer.setName("Rithik");
        customer.setAddress("Kandy");
        customer.setSalary(25550.00);

        session.save(customer);
        transaction.commit();
        session.close();
    }
}