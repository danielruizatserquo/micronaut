package es.serquo.micronaut.services;

import es.serquo.micronaut.errors.exceptions.ResourceNotFoundException;
import es.serquo.micronaut.models.Product;
import es.serquo.micronaut.repositories.ProductRepository;


import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Integer productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException());
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Integer productId, Product product) {
        Product productUpdatable = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException());
        productUpdatable.setName(product.getName());
        productUpdatable.setPrice(product.getPrice());
        productUpdatable.setQuantity(product.getQuantity());
        return productRepository.update(productUpdatable);

    }

    public void delete(Integer productId) {
        Product productDeletable = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException());
        productRepository.delete(productDeletable);
    }
}
