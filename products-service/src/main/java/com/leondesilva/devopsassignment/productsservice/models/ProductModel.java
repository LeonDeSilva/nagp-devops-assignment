package com.leondesilva.devopsassignment.productsservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class to represent the product model.
 */
@Entity
@Table(name = "products")
public class ProductModel implements Serializable {
    @Id
    private String id;
    private String name;
    private Integer quantity;

    /**
     * Method to get the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Method to set the id.
     *
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Method to get the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the quantity.
     *
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Method to set the quantity.
     *
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
