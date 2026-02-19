package com.klu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private Integer quality;

    private String imageUrl;

    // 🔹 Constructors
    public Product() {
    }

    public Product(String name, Double price, Integer quality, String imageUrl) {
        this.name = name;
        this.price = price;
        this.quality = quality;
        this.imageUrl = imageUrl;
    }

    // 🔹 Getters and Setters

    public Long getId() {
        return id;
    }

    // ⚠️ Optional: avoid setting ID manually if using auto-generation
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
