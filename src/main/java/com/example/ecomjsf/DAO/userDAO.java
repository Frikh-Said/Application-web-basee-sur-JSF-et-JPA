package com.example.ecomjsf.DAO;

import com.example.ecomjsf.entities.user;

import java.util.List;

public interface userDAO {
    public void save(user produit);
    public void update(user produit);
    public void delete(user produit);
    public user getOne(Long id);
    public List<user> getAll();
}
