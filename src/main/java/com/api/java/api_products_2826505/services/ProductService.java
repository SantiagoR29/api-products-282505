package com.api.java.api_products_2826505.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.java.api_products_2826505.entities.Product;
import com.api.java.api_products_2826505.repositories.ProductRepository;


@Service
public class ProductService {

   @Autowired
    private ProductRepository repository;

    //metdos 
    //READall
    public List<Product> findAll(){
        return (List<Product>)
            repository.findAll();
    }
    //read by id
    public Product findById(Long id){
        return repository.findById(id).get();
    }

    //insertar:
    public Product create(Product productoAGrabar){
        return repository.save(productoAGrabar);
    }

    //eliminar
    public Product borrar(Long id){
        //seleccionar el producto por id 
        Product pBorrar = this.findById(id);
        //borrar
        repository.delete(pBorrar);
        return pBorrar;
    }

    //Actualizar
    public Product actualizar(Long id, Product pUpdate){
        //1.encontrar el produto a actalizar
        Product p = this.findById(id);
        //2.actualizar atributos del payload
        p.setName(pUpdate.getName());
        p.setDescription(pUpdate.getDescription());
        p.setPrice(pUpdate.getPrice());
        //3.grabar cambos 
        return repository.save(p);
        
    } 


}
