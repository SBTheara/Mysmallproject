package com.example.pos.controller;
import com.example.pos.entity.Products;
import com.example.pos.repository.Products_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController{

    @Autowired
    private Products_Repository productsRepository;
    @GetMapping(value = "/getallproducts")
    public ResponseEntity<List<Products>> getallCustomer(){
        return new ResponseEntity<List<Products>>(productsRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/addnewproducts")
    public ResponseEntity<Products> addUser(@RequestBody Products products){
        return new ResponseEntity<Products>(productsRepository.save(products),HttpStatus.CREATED);
    }
    @PutMapping(value = "/updateproducts/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Integer id, @RequestBody Products products ){
        Products pro = new Products();
        pro = productsRepository.findById(id).get();
        pro.setName(products.getName());
        pro.setDescription(products.getDescription());
        pro.setImage(products.getImage());
        pro.setCategory_id(products.getCategory_id());
        pro.setQuantity(products.getQuantity());
        pro.setBrand(products.getBrand());
        pro.setModel(products.getModel());
        pro.setConfiguration(products.getConfiguration());
        pro.setPrice(products.getPrice());
        pro.setFeature(products.getFeature());
        pro.setCreate_at(products.getCreate_at());
        productsRepository.save(pro);
        return new ResponseEntity<String>("This product was updated",HttpStatus.OK);
    }
    @DeleteMapping(value = "/deleteproduct/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id){
        productsRepository.deleteById(id);
        return new ResponseEntity<String>("This product was deleted",HttpStatus.OK);
    }
}