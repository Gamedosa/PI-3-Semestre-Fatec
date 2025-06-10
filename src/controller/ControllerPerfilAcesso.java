package controller;

import dao.PerfilAcessoDAO;
import java.util.ArrayList;
import model.PerfilAcesso;

public class ControllerPerfilAcesso {

    PerfilAcessoDAO paDAO;
    
    public ControllerPerfilAcesso(){
        this.paDAO = new PerfilAcessoDAO();
    }
    
    public ArrayList<PerfilAcesso> controllerListaPerfilAcessos(){
        return paDAO.listaPerfilAcessoDAO();
    }
    
    public PerfilAcesso controllerRetornarPerfilAcesso(int id){
        return paDAO.retornarPerfilAcessoDAO(id);
    }
    
    public PerfilAcesso ControllerRetornarPerfilAcessoPorTipoDAO(String tipoAcesso){
        return paDAO.retornarPerfilAcessoPorTipoDAO(tipoAcesso);
    }
    
}
