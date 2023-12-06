package com.example.ecomjsf.DAO;

import com.example.ecomjsf.entities.produit;

import java.util.List;

public interface produitDAO {
    public void save(produit produit);
    public void update(produit produit);
    public void delete(produit produit);
    public produit getOne(Long id);
    public List<produit> getAll();
}
