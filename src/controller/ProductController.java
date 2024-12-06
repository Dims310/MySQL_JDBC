package controller;

import model.Product;
import repository.implement.ProductRepository;
import utils.DbConnection;

public class ProductController {
  DbConnection connection = new DbConnection();
  ProductRepository productRepository = new ProductRepository(connection.getConnection());

  public void get() {
    for (Product i : productRepository.get()) {
      System.out.println("ID Produk   : " + i.getId());
      System.out.println("Nama Produk : " + i.getName());
      System.out.println("Harga       : " + i.getPrice());
      System.out.println("Deksripsi   : " + i.getDescription());
      System.out.println("Stok        : " + i.getStock());
      System.out.println("Tersedia    : " + i.getStatus());
      System.out.println("Kategori    : " + i.getCategory().getName());
      System.out.println();
    }
  }

  public void getById(Integer id) {
    Product result = productRepository.getById(id);
    System.out.println("ID Produk   : " + result.getId());
    System.out.println("Nama Produk : " + result.getName());
    System.out.println("Harga       : " + result.getPrice());
    System.out.println("Deksripsi   : " + result.getDescription());
    System.out.println("Stok        : " + result.getStock());
    System.out.println("Tersedia    : " + result.getStatus());
    System.out.println("Kategori    : " + result.getCategoryId());
  }

  public void post() {
    Product product = new Product();
    product.setName("Mousepad");
    product.setPrice(1000);
    product.setDescription("Naah");
    product.setStock(30);
    product.setStatus(1);
    product.setCategoryId(2);

    Boolean result = productRepository.post(product);
    if (result) {
      System.out.println("Insert data success.");
    }
  }

  public void update() {
    Product product = new Product();
    product.setId(25);
    product.setName("Mousepad Sakti");
    product.setPrice(1000);
    product.setDescription("Mousepad licin gacor le, geser dikit muter balik");
    product.setStock(99);
    product.setStatus(1);
    product.setCategoryId(2);

    Boolean result = productRepository.update(product);
    if (result) {
      System.out.println("\nUpdate data success.");
    }
  }

  public void delete(Integer id) {
    Boolean result = productRepository.delete(id);
    if (result) {
      System.out.println("\nDelete data success.");
    }
  }
}
