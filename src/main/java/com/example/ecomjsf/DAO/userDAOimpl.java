package com.example.ecomjsf.DAO;

import com.example.ecomjsf.entities.user;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

    @ManagedBean
    @RequestScoped
    public class userDAOimpl implements  userDAO{

        EntityManagerFactory emf ;
        EntityManager em ;

        public userDAOimpl(){
            emf = Persistence.createEntityManagerFactory("default");
            em = emf.createEntityManager();
        }

        @Override
        public void save(user user) {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }

        @Override
        public void update(user user) {
            em.getTransaction().begin();
            if (!em.contains(user)) {
                em.merge(user);
            }
            em.getTransaction().commit();
        }

        @Override
        public void delete(user user) {
            em.getTransaction().begin();
            if (!em.contains(user)) {
                user = em.merge(user);
            }
            em.remove(user);
            em.getTransaction().commit();
        }

        @Override
        public user getOne(Long id) {
            Query query = em.createQuery( "select user from user user where user.id_user =:id");
            query.setParameter("id" , id);
            return (user) query.getSingleResult();
        }

        @Override
        public List<user> getAll() {
            Query query = em.createQuery( "select user from user user ");
            return query.getResultList() ;
        }

    }
