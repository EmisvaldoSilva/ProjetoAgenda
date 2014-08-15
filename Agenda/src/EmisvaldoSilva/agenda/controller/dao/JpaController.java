/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EmisvaldoSilva.agenda.controller.dao;


import EmisvaldoSilva.agenda.model.Contato;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import EmisvaldoSilva.agenda.model.Grupocontato;
import EmisvaldoSilva.agenda.model.Fone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emisvaldo
 */
public class JpaController <T> implements Serializable {
    
    private static EntityManager em;
    private static EntityManagerFactory emf;
    
    static{
        emf = Persistence.createEntityManagerFactory("AgendaPU");
        em = emf.createEntityManager();
    }

    public JpaController() {
    }
  

    public void create(T obj) {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch(Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    public void edit(T obj) {
        try {            
            em.getTransaction().begin();            
            obj = em.merge(obj);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    public void destroy(T obj) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(obj) );
            em.getTransaction().commit();
        } catch(Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace();
            
        }
        
    }

    public List<T> findEntities(Query query) {
        return findEntities(true, -1, -1, query);
    }

    public List<T> findEntities(int maxResults, int firstResult, Query query) {
        return findEntities(false, maxResults, firstResult, query);
    }
    
    public Query getQuery(String consulta){
        return em.createNamedQuery(consulta);
    }

    private List<T> findEntities(boolean all, int maxResults, int firstResult, Query query) {
            if (!all) {
                query.setMaxResults(maxResults);
                query.setFirstResult(firstResult);
            }
            return query.getResultList();
    }

    public T findContato(Class<T> classe, Long id) {
            return em.find(classe, id);
        
    }

    public int getCount(Class<T> classe) {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(classe);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        
    }
    
}
