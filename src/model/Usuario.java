package model;

public class Usuario {

    private int idusuario;
    private String nome;
    private String login;
    private String senha;
    private PerfilAcesso perfilAcesso;

    public Usuario() {
    }

    public Usuario(int idusuario, String nome, String login, String senha, PerfilAcesso perfilAcesso) {
        this.idusuario = idusuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.perfilAcesso = perfilAcesso;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PerfilAcesso getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }
    
    
    
}
