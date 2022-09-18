package com.sapient.oms.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeId;
    private String shopName;
    private int contactNumber;
    private String emailId;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private Collection<Inventory> inventory = new ArrayList<Inventory>();

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

    // public Store(int storeId, String shopName, int contactNumber, String emailId,
    // Location location2) {
    // this.storeId = storeId;
    // this.shopName = shopName;
    // this.contactNumber = contactNumber;
    // this.emailId = emailId;
    // this.location=location2;

    // }

    // public Store(int id2, String shopName2, Location location2, String emailId2,
    // int contact_number,
    // List<Product> product2) {
    // }

    public Store() {
    }

    public Store(int storeId, String shopName, int contactNumber, String emailId, Collection<Inventory> inventory,
            Location location) {
        this.storeId = storeId;
        this.shopName = shopName;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
        this.inventory = inventory;
        this.location = location;
    }

    public Store(int id2, String shopName2, int contactNumber2, String emailId2) {
    }

    public Store(int id3, String shopName3, int contactNumber3, String emailId3, HashSet<Inventory> inventory) {
        this.storeId = id3;
        this.shopName = shopName3;
        this.contactNumber = contactNumber3;
        this.emailId = emailId3;
    }

    public int getId() {
        return storeId;
    }

    public void setId(int storeId) {
        this.storeId = storeId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Collection<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(Collection<Inventory> inventory) {
        this.inventory = inventory;
    }

    // @Override
    // public int hashCode() {
    //     return this.storeId;
    // }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Store store = (Store) obj;
        if (this.storeId != store.storeId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Store [contactNumber=" + contactNumber + ", emailId=" + emailId + ", inventory=" + inventory
                + ", location=" + location + ", shopName=" + shopName + ", storeId=" + storeId + "]";
    }

    // @Override
    // public String toString() {
    //     return "Store [contactNumber=" + contactNumber + ", emailId=" + emailId + ", storeId=" + storeId + ", inventory="
    //             + inventory + ", location=" + location + ", shopName=" + shopName + "]";
    // }

    
    

}