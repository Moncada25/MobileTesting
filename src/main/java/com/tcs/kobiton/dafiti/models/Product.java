package com.tcs.kobiton.dafiti.models;

public class Product {

  private String productCategory;
  private String productName;
  private String productSize;

  public Product(String productCategory, String productName, String productSize) {
    this.productCategory = productCategory;
    this.productName = productName;
    this.productSize = productSize;
  }

  public String getProductCategory() {
    return productCategory;
  }

  public String getProductName() {
    return productName;
  }

  public String getProductSize() {
    return productSize;
  }
}
