package es.serquo.micronaut.repositories;

import es.serquo.micronaut.models.Product;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;

import java.util.List;

@JdbcRepository(dialect = Dialect.H2)
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Override
    List<Product> findAll();
}

