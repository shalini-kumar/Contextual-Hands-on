package com.sapient.oms.entity;

public class Store {
    
  //static int store_id=0;

  private int storeId;
  private String storeName;
  private String owner;
  private int contact;
  //private int locationId;
  //private List<Product> products;

  /*private void increment(){
    store_id++;
}
*/


public Store(int storeId, String storeName, String owner, int contact){
    this.storeId = storeId;
    this.storeName = storeName;
    this.owner = owner;
    this.contact = contact;
    //this.locationId = locationId;
    //this.products = products;
}



// overloaded constructor
/*public Store(String storeName,  Contact contact, String owner,  Location location){
    // store_id will be provided by system
   this(Integer.toString(Store.store_id),storeName,contact,owner,location);
   increment();
}y
*/

public int getStoreId() {
    return storeId;
}
public void setStoreId(int storeId) {
    this.storeId = storeId;
}
public String getStoreName() {
    return storeName;
}
public void setStoreName(String storeName) {
    this.storeName = storeName;
}
public String getOwner() {
    return owner;
}
public void setOwner(String owner) {
    this.owner = owner;
}
public int getContact() {
    return contact;
}
public void setContact(int contact) {
    this.contact = contact;
}

/*public int getLocation() {
    return locationId;
}
public void setLocation(int location) {
    this.locationId = location;
}
*/

@Override
public String toString() {
    
    return "[ StoreId:- "+this.storeId+", Store name:-  "+this.storeName+", Contact:- "+this.contact+", Owner:- "+this.owner+" ]\n";
}

}