package de.effectivetrainings.rest;

import de.effectivetrainings.domain.Product;
import de.effectivetrainings.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.LinkBuilder;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author <a href="mailto:martin.dilger.ext@pentasys.de">Martin Dilger</a>
 */
@RestController
@RequestMapping("/products")
public class ProductResource {


    private ProductService productService;

    private ProductResourceAssembler productResourceAssembler;

    @Autowired
    public ProductResource(ProductResourceAssembler resourceAssembler, ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/{id}")
    public BaseResource byId(@PathVariable(value = "id") Long id) {
        final Product product = productService.byId(id);
        return productResourceAssembler.toResource(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public Product remove(@PathVariable(value = "id") Long id) {
        return productService.remove(id);
    }

    @RequestMapping(value = "/")
    public List<Product> catalog() {
       return productService.catalog();
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public void newProduct(@RequestBody Product product) {
        productService.newProduct(product);
    }


}
