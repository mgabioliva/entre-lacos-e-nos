package dados;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ListaProjeto {
  
  public void cadastrar(Projeto p){
    EntityManager em = JPAUtil.getEntityManager();
    
    try {
      em.getTransaction().begin();
      em.persist(p);
      em.getTransaction().commit();
    }
    catch(Exception e){
      em.getTransaction().rollback();
      throw e;
    }
    finally{
      JPAUtil.closeEtityManager();
    }
  }
  
  public List<Projeto> listar(){
    
    EntityManager em = JPAUtil.getEntityManager();
    List<Projeto> projetos = new ArrayList<Projeto>();
    
    try{
      Query consulta = em.createQuery("SELECT p FROM Projeto p");
      projetos = consulta.getResultList();
    }
    catch(Exception e){
      em.getTransaction().rollback();
      throw e;
    }
    finally{
      JPAUtil.closeEtityManager();
    }
    return projetos;
  } 
    
  public void excluir(int id_projeto){
    EntityManager em = JPAUtil.getEntityManager();
    
    try{
      Projeto p = em.find(Projeto.class, id_projeto);
      if(p != null){
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
      }
    }
    catch(Exception e){
      em.getTransaction().rollback();
      throw e;
    }
    finally{
      JPAUtil.closeEtityManager();
    }
  }
  
  public Projeto obter(int id_projeto){
    EntityManager em = JPAUtil.getEntityManager();
    
    try{
      return em.find(Projeto.class, id_projeto);
    }
    finally{
      JPAUtil.closeEtityManager();
    }
  }
}
