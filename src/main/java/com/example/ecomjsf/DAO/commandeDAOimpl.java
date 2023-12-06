package com.example.ecomjsf.DAO;

import com.example.ecomjsf.entities.commande;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

    @ManagedBean
    @RequestScoped
    public class commandeDAOimpl implements  commandeDAO{

        EntityManagerFactory emf ;
        EntityManager em ;

        public commandeDAOimpl(){
            emf = Persistence.createEntityManagerFactory("default");
            em = emf.createEntityManager();
        }

        @Override
        public void save(commande commande) {
            em.getTransaction().begin();
            em.merge(commande);
            em.getTransaction().commit();
        }

        @Override
        public void update(commande commande) {
            em.getTransaction().begin();
            if (!em.contains(commande)) {
                em.merge(commande);
            }
            em.getTransaction().commit();
        }

        @Override
        public void delete(commande commande) {
            em.getTransaction().begin();
            if (!em.contains(commande)) {
                commande = em.merge(commande);
            }
            em.remove(commande);
            em.getTransaction().commit();
        }

        @Override
        public commande getOne(Long id) {
            Query query = em.createQuery( "select commande from commande commande where commande.id_commande =:id");
            query.setParameter("id" , id);
            return (commande) query.getSingleResult();
        }

        @Override
        public List<commande> getAll() {
            Query query = em.createQuery( "select commande from commande commande ");
            return query.getResultList() ;
        }

    }
