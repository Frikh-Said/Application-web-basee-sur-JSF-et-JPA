package com.example.ecomjsf.DAO;

import com.example.ecomjsf.entities.produit;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
    @ManagedBean
    @RequestScoped
    public class produitDAOimpl implements  produitDAO{

        EntityManagerFactory emf ;
        EntityManager em ;

        public produitDAOimpl(){
            emf = Persistence.createEntityManagerFactory("default");
            em = emf.createEntityManager();
        }

        @Override
        public void save(produit produit) {
            em.getTransaction().begin();
            em.merge(produit);
            em.getTransaction().commit();
        }

        @Override
        public void update(produit produit) {
            em.getTransaction().begin();
            if (!em.contains(produit)) {
                em.merge(produit);
            }
            em.getTransaction().commit();
        }

        @Override
        public void delete(produit produit) {
            em.getTransaction().begin();
            if (!em.contains(produit)) {
                produit = em.merge(produit);
            }
            em.remove(produit);
            em.getTransaction().commit();
        }

        @Override
        public produit getOne(Long id) {
            Query query = em.createQuery( "select produit from produit produit where produit.id_produit =:id");
            query.setParameter("id" , id);
            return (produit) query.getSingleResult();
        }

        @Override
        public List<produit> getAll() {
            Query query = em.createQuery( "select produit from produit produit ");
            return query.getResultList() ;
        }

    }
