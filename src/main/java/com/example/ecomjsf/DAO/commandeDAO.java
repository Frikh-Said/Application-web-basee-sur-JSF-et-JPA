package com.example.ecomjsf.DAO;

import com.example.ecomjsf.entities.commande;

import java.util.List;

public interface commandeDAO {
    public void save(commande commande);
    public void update(commande commande);
    public void delete(commande commande);
    public commande getOne(Long id);
    public List<commande> getAll();
}
