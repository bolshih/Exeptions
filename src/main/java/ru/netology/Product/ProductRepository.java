package ru.netology.Product;

public class ProductRepository {

    private Product[] products = new Product[0];


    public void addProduct(Product product) {
        if (findById(product.getId()) == null){
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }
        else {
            throw new AlreadyExistsException("Товар с id " + product.getId() + "уже существует");
        }
    }

    public Product[] getProducts() {

        return products;
    }

    public Product[] removeById(int id) throws NotFoundException {
        if (findById(id) != null) {
            Product[] tmp = new Product[products.length - 1];
            int copyToIndex = 0;
            for (Product product : products) {
                if (product.getId() != id) {
                    tmp[copyToIndex] = product;
                    copyToIndex++;
                }
            }
            products = tmp;
            return products;
        }
        else{
            throw new NotFoundException("Товар с id " + id + " не найден");
        }
    }
    public Product findById(int id) {
        for (Product product : getProducts()) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
