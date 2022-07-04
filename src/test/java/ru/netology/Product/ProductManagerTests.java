package ru.netology.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTests {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Книга1", 4234, "Автор1");
    Product product2 = new Smartphone(2, "Smartphone1", 33_000, "Manufacturer1");
    Product product3 = new Smartphone(3, "Smartphone2", 10_000, "Manufacturer2");
    Product product4 = new Book(4, "Книга2", 434, "Автор2");
    Product product5 = new Smartphone(5, "Smartphone3", 50_000, "Manufacturer1");
    Product product6 = new Book(6, "Книга3", 4234, "Автор1");

    @Test

    public void shouldAddProduct() {

        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
        manager.addProduct(product6);

        Product[] expected = {product1, product2, product3, product4, product5, product6};
        Product[] actual = manager.getProduct();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldThrowsAlreadyExistsException() {

        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
        manager.addProduct(product6);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            manager.addProduct(product3);
        });
    }

    @Test

    public void shouldRemovById() {

        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
        manager.addProduct(product6);

        Product[] expected = {product1, product2, product4, product5, product6};
        Product[] actual = manager.removeById(3);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldThrowsNotFoundException() {

        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
        manager.addProduct(product6);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(30);
        });
    }

}