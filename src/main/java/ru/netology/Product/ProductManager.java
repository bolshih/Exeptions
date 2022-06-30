package ru.netology.Product;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {

        this.repo = repo;
    }

    public void addProduct(Product product) {

        repo.addProduct(product);
    }

    public Product[] getProduct() {

        return repo.getProducts();
    }

    public Product[] removeById(int id){

        return repo.removeById(id);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.getProducts()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}