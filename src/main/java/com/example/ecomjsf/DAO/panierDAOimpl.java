package com.example.ecomjsf.DAO;

import com.example.ecomjsf.entities.panier;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

@ManagedBean
@RequestScoped
public class panierDAOimpl implements panierDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public panierDAOimpl() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    @Override
    public void save(panier panier) {
        em.getTransaction().begin();
        em.merge(panier);
        em.getTransaction().commit();
    }

    @Override
    public void update(panier panier) {
        em.getTransaction().begin();
        if (!em.contains(panier)) {
            panier = em.merge(panier);
        }
        em.getTransaction().commit();
    }

    @Override
    public void delete(panier panier) {
        em.getTransaction().begin();
        if (!em.contains(panier)) {
            panier = em.merge(panier);
        }
        em.remove(panier);
        em.getTransaction().commit();
    }

    @Override
    public panier getOne(Long id) {
        Query query = em.createQuery("select panier from panier panier where panier.id_panier = :id");
        query.setParameter("id", id);
        return (panier) query.getSingleResult();
    }

    @Override
    public List<panier> getAll() {
        Query query = em.createQuery("select panier from panier panier");
        return query.getResultList();
    }
}
