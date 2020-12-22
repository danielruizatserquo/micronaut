package es.serquo.micronaut;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import javax.inject.Singleton;



@OpenAPIDefinition(
        info = @Info(
                title = "demo",
                version = "0.0",
                description = "Testing Swagger"
        )
)
@Singleton
public class DemoApplication {

    public static void main(String[] args) {
        Micronaut.run(args);
    }



}
