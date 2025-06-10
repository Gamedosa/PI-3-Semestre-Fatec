package model;

public class PerfilAcesso {

    private int idperfilAcesso;
    private String tipoPerfil;

    public PerfilAcesso() {
    }

    public PerfilAcesso(int idperfilAcesso, String tipoPerfil) {
        this.idperfilAcesso = idperfilAcesso;
        this.tipoPerfil = tipoPerfil;
    }

    public int getIdperfilAcesso() {
        return idperfilAcesso;
    }

    public void setIdperfilAcesso(int idperfilAcesso) {
        this.idperfilAcesso = idperfilAcesso;
    }

    public String getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(String tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }
    
    
    
}
