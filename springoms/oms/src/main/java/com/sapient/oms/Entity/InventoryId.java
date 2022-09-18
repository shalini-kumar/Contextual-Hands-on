package com.sapient.oms.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InventoryId implements Serializable {
    @Column(name = "store_id")
    private int storeId;
    @Column(name = "product_id")
    private int productId;

    public InventoryId() {
    }

    public InventoryId(int storeId, int productId) {
        this.storeId = storeId;
        this.productId = productId;
    }

    // public int hashCode() {
    // return (int)(storeId + productId);
    // }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + productId;
        result = prime * result + storeId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InventoryId other = (InventoryId) obj;
        if (productId != other.productId)
            return false;
        if (storeId != other.storeId)
            return false;
        return true;
    }

}
