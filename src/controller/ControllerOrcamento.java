package controller;

import dao.OrcamentoDAO;
import java.util.ArrayList;
import model.Orcamento;

public class ControllerOrcamento {

    private OrcamentoDAO orcDAO;
    
    public ControllerOrcamento(){
        this.orcDAO = new OrcamentoDAO();
    }
    
    public boolean controllerCadastrarOrcamento(Orcamento orc){
        return orcDAO.cadastrarOrcamentoDAO(orc);
    }
    
    public boolean controllerAtualizarOrcamento(Orcamento orc){
        return orcDAO.atualizarOrcamentoDAO(orc);
    }
    
    public boolean controllerExcluirOrcamento(int id){
        return orcDAO.deleteOrcamentoDAO(id);
    }
    
    public Orcamento controllerRetornaOrcamento(int id){
        return orcDAO.retornaOrcamentoDAO(id);
    }
    
    public ArrayList<Orcamento> listarOrcamento(){
        return orcDAO.ListaOrcamentoDAO();
    }
    
}
