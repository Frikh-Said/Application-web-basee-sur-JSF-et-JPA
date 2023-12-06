package com.example.ecomjsf.jsfBeans;

import com.example.ecomjsf.DAO.userDAO;
import com.example.ecomjsf.entities.user;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class userManagedBean {
    @Inject
    userDAO userDAO ;
    private Long id_user ;
    private String nom ;
    public void save(){
        userDAO.save(new user());
    }
    public List<user> users(){
        return userDAO.getAll();
    }
    public void delete(Long id ){
        userDAO.delete( userDAO.getOne(id) );
    }

    public String login() {
        if ("votre_utilisateur".equals(nom)) {
            return "accueil";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur d'authentification", "Nom d'utilisateur incorrect."));
            return null;
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/pages/login?faces-redirect=true";
    }
}
