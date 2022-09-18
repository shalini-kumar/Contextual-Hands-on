package com.sapient.oms.Entity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @NotNull
    private String customerName;
    private String password;

    @Email
    private String email;

    @OneToOne(mappedBy = "customer")
    @JsonManagedReference
    private Cart cart;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<Order> order;

    public Customer() {

    }

    public Customer(int customerId, String customerName, String password, String email, List<Order> order) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.password = password;
        this.email = email;
        this.order=order;
    }

    public Customer(int id, String customerName, String password, String email) {
        this.customerId = id;
        this.customerName = customerName;
        this.password = password;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email + ", password=" + password + "]";
    }

}