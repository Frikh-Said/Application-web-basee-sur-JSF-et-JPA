package com.example.ecomjsf.jsfBeans;

import com.example.ecomjsf.DAO.produitDAO;
import com.example.ecomjsf.entities.produit;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@ManagedBean
@RequestScoped
public class produitManagedBean {

    private produit produit;
    private Long produitId;

    @Inject
    private produitDAO produitDao;

    public produitManagedBean() {
        produit = new produit();
    }

    public void saveProduit() {
        produitDao.save(produit);
    }

    public void updateProduit() {
        produitDao.update(produit);
    }

    public void deleteProduit() {
        produit produitToDelete = produitDao.getOne(produitId);
        produitDao.delete(produitToDelete);
    }


    public produit getProduit() {
        return produit;
    }

    public void setProduit(produit produit) {
        this.produit = produit;
    }

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }
}
