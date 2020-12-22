package es.serquo.micronaut.controllers;

import es.serquo.micronaut.models.Product;
import es.serquo.micronaut.services.ProductService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.inject.Inject;
import java.util.List;


@Controller("/products")
public class ProductController {

    @Inject
    private ProductService productService;

    @Get
    public HttpResponse<List<Product>> getProducts() {
        return HttpResponse.status(HttpStatus.OK).body( productService.findAll());
    }

    @Get("/{productId}")
    public HttpResponse<Product> getProduct(@PathVariable Integer productId) {
        return HttpResponse.status(HttpStatus.OK).body(productService.findById(productId));
    }

    @Post
    public HttpResponse<Product> createProduct(Product product) {
        return HttpResponse.status(HttpStatus.CREATED).body(productService.create( product));
    }

    @Put("/{productId}")
    public HttpResponse<Product>  updateProduct(@PathVariable Integer productId, Product product) {
        return HttpResponse.status(HttpStatus.ACCEPTED).body(productService.update(productId, product) );
    }

    @Delete("/{productId}")
    public HttpStatus deleteProduct(@PathVariable Integer productId) {
        productService.delete(productId);
        return HttpStatus.OK;
    }
}