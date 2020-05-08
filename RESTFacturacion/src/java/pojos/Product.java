/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author elascano
 * @version 1.0.2
 * @since 2017-17-12
 */

public class Product {
    private int id;
    private String name;
    private int quantity;
    private float price;
    private String [] tags = new String[2];

    public Product(int id, String name, int quantity, float price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    public Product(int id, String name, int quantity, float price, String[] tags) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.tags=tags;
    }

    public Product() {
        this.id = 0;
        this.name = "";
        this.quantity = 0;
        this.price = 0;
        this.tags=null;
    }


    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;

    }

    /**
     * @return the tags
     */
    public String[] getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    
}
