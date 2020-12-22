package es.serquo.micronaut.errors;

import es.serquo.micronaut.errors.exceptions.ResourceNotFoundException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;

import javax.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {ResourceNotFoundException.class, ExceptionHandler.class})
public class ResourceNotFoundHandler implements ExceptionHandler<ResourceNotFoundException, HttpResponse> {
    @Override
    public HttpResponse handle(HttpRequest request, ResourceNotFoundException exception) {
        return HttpResponse.notFound();
    }
}
