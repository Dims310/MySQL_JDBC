import controller.ProductController;

public class App {
    public static void main(String[] args) throws Exception {
        // DbConnection connection = new DbConnection();
        // System.out.println(connection.getConnection());

        // System.out.println("Hello, World!");

        ProductController productController = new ProductController();
        productController.get();

        // productController.post();

        // cek produk id 10
        productController.getById(10);

        productController.update();

        // cek apakah udah keupdate
        productController.getById(25);

        productController.delete(25);

        // cek apakah udh kedelete
        productController.get();

    }
}
