package repository;

import java.util.List;

import model.Product;

public interface IProductRepository {
  List<Product> get();
  Product getById(Integer id);
  Boolean post(Product product);
  Boolean update(Product product);
  Boolean delete(Integer id);
}
