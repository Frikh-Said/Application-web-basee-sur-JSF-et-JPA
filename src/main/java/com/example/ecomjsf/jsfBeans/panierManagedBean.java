package com.example.ecomjsf.jsfBeans;

import com.example.ecomjsf.DAO.panierDAO;
import com.example.ecomjsf.entities.panier;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@ManagedBean
@RequestScoped
public class panierManagedBean {

    private panier panier;
    private Long panierId;

    @Inject
    private panierDAO panierDao;

    public panierManagedBean() {
        panier = new panier();
    }

    public void savePanier() {
        panierDao.save(panier);
    }

    public void updatePanier() {
        panierDao.update(panier);
    }

    public void deletePanier() {
        panier panierToDelete = panierDao.getOne(panierId);
        panierDao.delete(panierToDelete);
    }

    public panier getPanier() {
        return panier;
    }

    public void setPanier(panier panier) {
        this.panier = panier;
    }

    public Long getPanierId() {
        return panierId;
    }

    public void setPanierId(Long panierId) {
        this.panierId = panierId;
    }
}
