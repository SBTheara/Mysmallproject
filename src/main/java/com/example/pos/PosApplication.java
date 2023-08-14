package com.example.pos;

import com.example.pos.entity.Category;
import com.example.pos.entity.Products;
import com.example.pos.entity.Users;
import com.example.pos.repository.Category_Repository;
import com.example.pos.repository.Products_Repository;
import com.example.pos.repository.Users_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PosApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(PosApplication.class, args);
    }
    @Autowired
    private Products_Repository productsRepository;
    @Autowired
    private Users_Repository usersRepository;
    @Autowired
    private Category_Repository categoryRepository;
    @Override
    public void run(String... args) throws Exception {
        Users user = new Users("Hello","world","helloworld@gmail.com","1234","Kandal","012 334 556","Simple",1);
        this.usersRepository.save(user);
        Category category = new Category("Beverages","the product for drink not for throw");
        Products pro = new Products(
                "coca cola","energydrink",1,"Coca Cola","coca cola","drink",2500,3,3
        );
        Products pro1 = new Products(
                "Sting","energydrink",10,"Coca Cola","coca cola","Bevereges",2000,3,3
        );
        category.getProducts().add(pro);
        category.getProducts().add(pro1);
        this.categoryRepository.save(category);
    }
}
