package dados;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaUsuario {
  
  public void cadastrar(Usuario u){
    EntityManager em = JPAUtil.getEntityManager();
    
    try {
      em.getTransaction().begin();
      em.persist(u);
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
  
  public List<Usuario> listar(){
    
    EntityManager em = JPAUtil.getEntityManager();
    List<Usuario> usuarios = new ArrayList<Usuario>();
    
    try{
      Query consulta = em.createQuery("SELECT u FROM Usuario u");
      usuarios = consulta.getResultList();
    }
    catch(Exception e){
      em.getTransaction().rollback();
      throw e;
    }
    finally{
      JPAUtil.closeEtityManager();
    }
    return usuarios;
  } 
  
  public Usuario obter(int id_usuario){
    EntityManager em = JPAUtil.getEntityManager();
    
    try{
      return em.find(Usuario.class, id_usuario);
    }
    finally{
      JPAUtil.closeEtityManager();
    }
  }
  
  public static Usuario validarUsuario(Usuario usuario) {
    
    String sql = "SELECT * FROM usuario WHERE username = ? AND senha = ?";
    Usuario usuarioEncontrado = null;
    
    try {
      Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/entrelacosenos", "root", "2008");
      PreparedStatement statement = conexao.prepareStatement(sql);

        statement.setString(1, usuario.getUsername());
        statement.setString(2, usuario.getSenha());

        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
          usuarioEncontrado = new Usuario();
          usuarioEncontrado.setId_usuario(rs.getInt("id_usuario"));
          usuarioEncontrado.setNome(rs.getString("nome"));
          usuarioEncontrado.setUsername(rs.getString("username"));
          usuarioEncontrado.setEmail(rs.getString("email"));
          usuarioEncontrado.setSenha(rs.getString("senha"));
          usuarioEncontrado.setBiografia(rs.getString("biografia"));
          usuarioEncontrado.setTipoUsuario(rs.getString("tipoUsuario"));
        }
    } catch (SQLException ex) {
      System.out.println("Erro ao validar usuário: " + ex.getMessage());
    }
    return usuarioEncontrado;
  }
}
