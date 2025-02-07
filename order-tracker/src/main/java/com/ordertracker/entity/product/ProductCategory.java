package com.ordertracker.entity.product;

public enum ProductCategory {
    ELECTRONICS("Electronics"),
    MOBILE_PHONES("Mobile phones"),
    TOY_GAMES("Toy & Games"),
    FASHION("Fashion");
    
    private String categoryName;
    
    ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public String getCategoryName() {
        return categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
