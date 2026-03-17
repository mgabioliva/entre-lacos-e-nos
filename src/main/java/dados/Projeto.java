package dados;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalTime;

@Entity
public class Projeto {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id_projeto;
  private String nome;
  private String categoria;
  private LocalTime duracao;
  private String material;
  private String status;
  private String detalhes;
  @ManyToOne
  @JoinColumn(name="id_usuario")
  private Usuario usuario;
  @ManyToOne
  @JoinColumn(name="id_receita")
  private Receita receita;
  
  
  public int getId_projeto() { 
    return id_projeto; 
  }
  public void setId_projeto(int id_projeto) { 
    this.id_projeto = id_projeto; 
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
  
  public LocalTime getDuracao(){
    return duracao;
  }
  public void setDuracao(LocalTime duracao) { 
    this.duracao = duracao; 
  } 
  
  public String getMaterial() { 
    return material; 
  }
  public void setMaterial(String material) { 
    this.material = material; 
  } 
  
  public String getStatus() { 
    return status; 
  }
  public void setStatus(String status) { 
    this.status = status; 
  }
  
  public String getDetalhes() { 
    return detalhes; 
  }
  public void setDetalhes(String detalhes) { 
    this.detalhes = detalhes; 
  }
  
  public Usuario getUsuario() { 
    return usuario; 
  }
  public void setUsuario(Usuario usuario) { 
    this.usuario = usuario; 
  } 
  
  public Receita getReceita() { 
    return receita; 
  }
  public void setReceita(Receita receita) { 
    this.receita = receita; 
  }
  
  @Override
  public String toString() {
    return "Projeto{" + "nome='" + nome + '\'' + ", categoria=" + categoria + '\'' +
     ", duracao=" + duracao  + ", status=" + status + '\''  + ", detalhes=" + detalhes + '\''  + '}';
  }
}
