package dados;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Receita {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id_receita;
  private String nome;
  private String categoria;
  private String dificuldade;
  private String material;
  private String conteudo;
  @ManyToOne
  @JoinColumn(name="id_usuario")
  private Usuario usuario;
  
  
  public int getId_receita() {
    return id_receita;
  }
  public void setId_receita(int id_receita) {
    this.id_receita = id_receita;
  }
  
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome; 
  } 
  
  public String getCategoria() { 
    return categoria; 
  }
  public void setCategoria(String categoria) { 
    this.categoria = categoria; 
  } 
  
  public String getDificuldade() { 
    return dificuldade; 
  }
  public void setDificuldade(String dificuldade) { 
    this.dificuldade = dificuldade; 
  }
  
  public String getMaterial() { 
    return material; 
  }
  public void setMaterial(String material) { 
    this.material = material; 
  } 
  
   public String getConteudo(){
    return conteudo;
  }
  public void setConteudo(String conteudo) { 
    this.conteudo = conteudo; 
  } 
  
  public Usuario getUsuario() { 
    return usuario; 
  }
  public void setUsuario(Usuario usuario) { 
    this.usuario = usuario; 
  }
  
  @Override
public String toString() {
    return id_receita + " - " + nome;
}
  
}
