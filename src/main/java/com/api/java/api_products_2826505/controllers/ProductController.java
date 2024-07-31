package com.api.java.api_products_2826505.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.java.api_products_2826505.entities.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.java.api_products_2826505.services.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService  servicio;

    //primer endpoint
    //traer todos los prductos 
    //Traer: petciones de GET
    @GetMapping("/productos")
    public List<Product> finAllProducts() {
        //utilxar el service para 
        //traer los products
        //necesitamos una instancia 
        //del dervice en el controller
        return servicio.findAll();

    }

    //segundo endpoint
    //traer un produt por id
    //Metdo http: GET
    @GetMapping("/productoporid/{id}")
    public Product finProductById(@PathVariable Long id){
        return servicio.findById(id);
    }

    //tercer endpoint 
    //grabar un nuevo producto 
    //que llegue por el body de la request(payload)

    @PostMapping("/nuevoproducto")
    public Product newProduct(@RequestBody Product p) {
        return servicio.create(p);
    }
    
    //cuarto endpoint 
    //borrar un producto por id 
    //Method HTTP: DELETE
    @DeleteMapping("/borrarporid/{id}")
    public Product deleteProductById(@PathVariable Long id){
         return servicio.borrar(id);
    }
    
    //quinto endpoint 
    @PutMapping("actualizarporid/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product p) {
        return servicio.actualizar(id, p);
    }

}
