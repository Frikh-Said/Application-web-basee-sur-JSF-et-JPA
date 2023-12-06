package com.example.ecomjsf.jsfBeans;

import com.example.ecomjsf.DAO.commandeDAO;
import com.example.ecomjsf.entities.commande;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@ManagedBean
@RequestScoped
public class commandeManagedBean {

    private commande commande;
    private Long commandeId;

    @Inject
    private commandeDAO commandeDao;

    public commandeManagedBean() {
        commande = new commande();
    }

    public void saveCommande() {
        commandeDao.save(commande);
    }

    public void updateCommande() {
        commandeDao.update(commande);
    }

    public void deleteCommande() {
        commande commandeToDelete = commandeDao.getOne(commandeId);
        commandeDao.delete(commandeToDelete);
    }

    public commande getCommande() {
        return commande;
    }

    public void setCommande(commande commande) {
        this.commande = commande;
    }

    public Long getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(Long commandeId) {
        this.commandeId = commandeId;
    }
}