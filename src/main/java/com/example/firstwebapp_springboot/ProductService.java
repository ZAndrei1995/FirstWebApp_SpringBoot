package com.example.firstwebapp_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository ;

    public List<tipurimasini> listAll() {
        return (List<tipurimasini>) productRepository.findAll();
    }

    public void save(tipurimasini tipurimasini) {
        productRepository.save(tipurimasini);
    }

    public tipurimasini getID ( int id ) {
        return productRepository.findById(id).get() ;
    }

    public void deleteFromDB( int id ) {
        productRepository.deleteById(id);
    }

}
