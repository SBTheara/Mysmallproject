package com.example.pos.repository;

import com.example.pos.entity.FileImageDB;
import com.example.pos.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
public interface Products_Repository extends JpaRepository<Products,Integer> {

    @Query(value = "select i.img_id from file_img as i inner join products as p on i.product_id = p.product_id where p.product_id = :id",nativeQuery = true)
    public String findImageByID(@Param("id") long i);
}
