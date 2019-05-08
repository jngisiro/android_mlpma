package com.subtledesigns.mlpma.model;

import java.util.UUID;

public class Product {
    private String name;
    private String id;
    private String category;
    private String description;
    private int price;
    private String img_url;
    private String vendor;

    public Product(String _name, String _description, int _price, String _img_url, String _vendor,
                   String _category){
        id = UUID.randomUUID().toString();
        name = _name;
        category = _category;
        description = _description;
        price = _price;
        img_url = _img_url;
        vendor = _vendor;
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public String getCategory() { return  category; }
    public String getDescription() { return description; }
    public int getPrice() { return price; }
    public String getImg_url() { return img_url; }
    public String getVendor() { return vendor; }

    public void setName(String _name) { this.name = _name; }
    public void setCategory(String _category) { this.category = _category; }
    public void setDescription(String _description) { this.description = _description; }
    public void setPrice(int _price) { this.price = _price; }
    public void setImg_url(String _img_url){ this.img_url = _img_url; }
    public void vendor(String _vendor){ this.vendor = _vendor; }

}
