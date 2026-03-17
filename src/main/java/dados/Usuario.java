package dados;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id_usuario;
  private String nome;
  private String username;
  private String email;
  private String senha;
  private String biografia;
  private String tipoUsuario;
  
  
  public int getId_usuario() { 
    return id_usuario; 
  }
  public void setId_usuario(int id_usuario) { 
    this.id_usuario = id_usuario; 
  } 
  
  public String getNome() { 
    return nome; 
  }
  public void setNome(String nome) { 
    this.nome = nome; 
  }
  
  public String getUsername() { 
    return username; 
  }
  public void setUsername(String username) { 
    this.username = username; 
  } 
  
  public String getEmail() { 
    return email; 
  }
  public void setEmail(String email) { 
    this.email = email; 
  } 
  
  public String getSenha() { 
    return senha; 
  }
  public void setSenha(String senha) { 
    this.senha = senha; 
  } 
  
  public String getBiografia() { 
    return biografia; 
  }
  public void setBiografia(String biografia) { 
    this.biografia = biografia; 
  }
  
  public String getTipoUsuario() { 
    return tipoUsuario; 
  }
  public void setTipoUsuario(String tipoUsuario) { 
    this.tipoUsuario = tipoUsuario; 
  }
  
  @Override
  public String toString() {
    return this.username;
  }

}


  
