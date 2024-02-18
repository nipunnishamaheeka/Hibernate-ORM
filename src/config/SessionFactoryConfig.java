package config;

import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {
    public static SessionFactoryConfig factoryConfig;

    private final SessionFactory sessionFactory;

    private SessionFactoryConfig() {

        // 2. Creates a MetaData object
//       sessionFactory= new MetadataSources(new StandardServiceRegistryBuilder()
//                .loadProperties("hibernate.properties")
//                .build())
//                .addAnnotatedClass(Customer.class)
//                .getMetadataBuilder().build()
//               .buildSessionFactory();
// 3. Create Factory short
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
        return (null == factoryConfig) ? factoryConfig = new SessionFactoryConfig() : factoryConfig;

    }

    public Session getSession() {

        // 4. Create and open
        return sessionFactory.openSession();

    }
}
