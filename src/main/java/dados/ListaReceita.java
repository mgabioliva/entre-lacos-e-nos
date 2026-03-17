package dados;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ListaReceita {
  
  public void cadastrar(Receita r){
    EntityManager em = JPAUtil.getEntityManager();
    
    try {
      em.getTransaction().begin();
      em.persist(r);
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
  
  public List<Receita> listar(){
    
    EntityManager em = JPAUtil.getEntityManager();
    List<Receita> receitas = new ArrayList<Receita>();
    
    try{
      Query consulta = em.createQuery("SELECT r FROM Receita r");
      receitas = consulta.getResultList();
    }
    catch(Exception e){
      em.getTransaction().rollback();
      throw e;
    }
    finally{
      JPAUtil.closeEtityManager();
    }
    return receitas;
  } 
  
  public void excluir(int id_receita){
    EntityManager em = JPAUtil.getEntityManager();
    
    try{
      Receita r = em.find(Receita.class, id_receita);
      if(r != null){
        em.getTransaction().begin();
        em.remove(r);
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
  
  public Receita obter(int id_receita){
    EntityManager em = JPAUtil.getEntityManager();
    
    try{
      return em.find(Receita.class, id_receita);
    }
    finally{
      JPAUtil.closeEtityManager();
    }
  }
}
