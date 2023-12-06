package com.example.ecomjsf.DAO;

import com.example.ecomjsf.entities.panier;

import java.util.List;

public interface panierDAO {
    void save(panier panier);

    void update(panier panier);

    void delete(panier panier);

    panier getOne(Long id);

    List<panier> getAll();
}
