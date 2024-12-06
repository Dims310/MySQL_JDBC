package repository.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import model.Product;
import repository.IProductRepository;

public class ProductRepository implements IProductRepository{
  private Connection connection;

  public ProductRepository(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Product> get() {
    List<Product> products = new ArrayList<>();
    // String query = "SELECT * FROM tb_products";

    String query = """
        SELECT p.id, p.name, p.price, p.description, p.stock, p.status, 
               c.id AS category_id, c.name AS category_name
        FROM tb_products p
        INNER JOIN tb_m_categories c ON p.tb_m_categories_id = c.id
    """;

    try {
      ResultSet resultSet = connection.prepareStatement(query).executeQuery();
      while (resultSet.next()) {
        Product product = new Product();
        product.setId(resultSet.getInt(1));
        product.setName(resultSet.getString(2));
        product.setPrice(resultSet.getInt(3));
        product.setDescription(resultSet.getString(4));
        product.setStock(resultSet.getInt(5));
        product.setStatus(resultSet.getInt(6));
        // product.setCategoryId(resultSet.getInt(7));

        model.Category category = new model.Category();
        category.setId(resultSet.getInt("category_id"));
        category.setName(resultSet.getString("category_name"));
        product.setCategory(category);

        products.add(product);
      } 
    } catch (Exception e) {
      e.printStackTrace();
    }

    return products;
  }

  @Override
  public Boolean post(Product product) {
    String query = "INSERT INTO tb_products(name, price, description, stock, status, tb_m_categories_id) VALUES (?,?,?,?,?,?)";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, product.getName());
      preparedStatement.setInt(2, product.getPrice());
      preparedStatement.setString(3, product.getDescription());
      preparedStatement.setInt(4, product.getStock());
      preparedStatement.setInt(5, product.getStatus());
      preparedStatement.setInt(6, product.getCategoryId());
      Integer result = preparedStatement.executeUpdate();
      return result > 0;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }

  @Override
  public Product getById(Integer id) {
    String query = "SELECT * FROM tb_products WHERE id = (?)";
    Product product = new Product();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, id);

      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        product.setId(resultSet.getInt(1));
        product.setName(resultSet.getString(2));
        product.setPrice(resultSet.getInt(3));
        product.setDescription(resultSet.getString(4));
        product.setStock(resultSet.getInt(5));
        product.setStatus(resultSet.getInt(6));
        product.setCategoryId(resultSet.getInt(7));
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }

    return product;
  }

  @Override
  public Boolean update(Product product) {
    Product productId = getById(product.getId()); // if product was found

    if (productId != null) {
      String query = "UPDATE tb_products SET name=(?), price=(?), description=(?), stock=(?), status=(?), tb_m_categories_id=(?) WHERE id = (?)";  
      try {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setInt(2, product.getPrice());
        preparedStatement.setString(3, product.getDescription());
        preparedStatement.setInt(4, product.getStock());
        preparedStatement.setInt(5, product.getStatus());
        preparedStatement.setInt(6, product.getCategoryId());
        preparedStatement.setInt(7, productId.getId());
  
        Integer result = preparedStatement.executeUpdate();
        return result > 0;
      } catch (Exception e) {
        System.out.println("Error le coba meneh");
        e.printStackTrace();
      }
    }

    return false;
  }

  @Override
  public Boolean delete(Integer id) {
    Product productId = getById(id); // if product was found

    if (productId != null) {
      String query = "DELETE FROM tb_products WHERE id = (?)";
      
      try {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        
        Integer result = preparedStatement.executeUpdate();
        return result > 0;
      } catch (Exception e) {
        System.out.println("Error meneh le");
        e.printStackTrace();
      }
    }

    return false;
  }
  
}