package entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private int id;

    @Column(name = "order_description")
    private String description;


    @Column(name = "order_date")
    @CreationTimestamp
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
