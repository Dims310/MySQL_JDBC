package model;

public class Product {
  private Integer id;
  private String name;
  private Integer price;
  private String description;
  private Integer stock;
  private Integer status;
  private Integer categoryId;
  private Category category;
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Integer getPrice() {
    return price;
  }
  public void setPrice(Integer price) {
    this.price = price;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Integer getStock() {
    return stock;
  }
  public void setStock(Integer stock) {
    this.stock = stock;
  }
  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }
  public Integer getCategoryId() {
    return categoryId;
  }
  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }
  public Category getCategory() {
    return category;
  }
  public void setCategory(Category category) {
    this.category = category;
  }


}
