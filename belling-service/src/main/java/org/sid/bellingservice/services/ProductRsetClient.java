package org.sid.bellingservice.services;

import org.sid.bellingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRsetClient {
    @GetMapping(path = "/products/{id}")
     Product findProductById(@PathVariable long id);
    @GetMapping("/products")
    PagedModel<Product> allProducts();
}
