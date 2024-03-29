package entity;

import embedded.NameIdentifier;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

//@Entity(name = "customer")
@Entity
@Table(name = "customer")
public class Customer {


    @CreationTimestamp
    @UpdateTimestamp
    //Create and update dekama ekapara use wenna be
    @Column(name = "date_type")
    private Timestamp createdDateType;

    @Id // Tells Hibernate that this is the primary key of this annotation
    @Column(name = "custmer_id")
    private int id;
    @Column(name = "customer_name")
    private NameIdentifier name;
    @Column(name = "customer_address")
    private String address;
    @Column(name = "customer_salary")
    private Double salary;

    @Column(name = "mobile_number")
    private int mobileNumber;

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

//    public Customer(int id, String name, String address, Double salary) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.salary = salary;
//    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", mobileNumber=" + mobileNumber +
                '}';
    }
}
