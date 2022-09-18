package com.sapient.oms.Repository;

import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//import com.sapient.oms.entity.Location;
import com.sapient.oms.entity.Product;
//import com.sapient.oms.entity.Store;

public class ManageStore {
    private static SessionFactory factory;

    /**
     * @param args
     */
    public static void main(String args[]) {
        try {
            // factory = new Configuration().configure().buildSessionFactory();
            factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        /*
         * ManageStore store_mng = new ManageStore( );
         * Store store = new Store(12, "Z enterprises","Vikram",1,11);
         * //Location location = new
         * Location(1,"TechPark","Chennai","TamilNadu","India",600077);
         * Product product = new Product(1,"Chocolates",50,new Date(),new Date());
         * store_mng.addStore(store);
         * System.out.println(store_mng.addStore(store));
         * System.out.println(store_mng.addProduct(product));
         * //System.out.println(store_mng.addLocation(location));
         */
        ManageStore manageStore = new ManageStore();
        //Store store = new Store(001, "Z enterprises", "Vikram", 99402);
        // storeAddress address = new storeAddress(001, "Z street", "Chennai", "TN",
        // "India", 622005);
        Product product = new Product(002, "Chocolates", 100, new Date(), new Date());
        //manageStore.addStore(store);
        // obj.addLocation(address);
        manageStore.addProduct(product);
        System.out.println(manageStore);
    }

    /*public Integer addStore(Store store) {

        Session session = factory.openSession();
        Transaction tx = null;
        Integer storeId = null;

        try {
            tx = session.beginTransaction();
            storeId = (Integer) session.save(store);
            tx.commit();
        } catch (HibernateException hibr_ex) {
            if (tx != null)
                tx.rollback();
            System.out.println(hibr_ex.getMessage());
        } finally {
            session.close();
        }
        return storeId;
    }
*/
    
     public Integer addProduct(Product product) {
      Session session = factory.openSession();
      Transaction tx = null;
      Integer productId = null;
     
     try {
      tx = session.beginTransaction();
      productId = (Integer) session.save(product);
      tx.commit();
      } 
      catch (HibernateException hibr_ex) {
         if (tx != null)
         tx.rollback();
         System.out.println(hibr_ex.getMessage());
      } finally {
      session.close();
      }
      
      return productId;
      }
     

    /*
     * public Integer addLocation(Location location) {
     * 
     * Session session = factory.openSession();
     * Transaction tx = null;
     * Integer locationId = null;
     * 
     * try {
     * 
     * tx = session.beginTransaction();
     * locationId = (Integer) session.save(location);
     * tx.commit();
     * 
     * } catch (HibernateException hbr_ex) {
     * 
     * if (tx != null)
     * tx.rollback();
     * System.out.
     * println("Error Occured while insertingt he timing into the database");
     * } finally {
     * session.close();
     * }
     * 
     * return locationId;
     * }
     */
}
