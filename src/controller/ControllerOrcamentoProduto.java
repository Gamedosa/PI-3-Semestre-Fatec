package controller;

import dao.OrcamentoProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import model.OrcamentoProduto;

public class ControllerOrcamentoProduto {

    private OrcamentoProdutoDAO opDAO;
    
    public ControllerOrcamentoProduto(){
        this.opDAO = new OrcamentoProdutoDAO();
    }
    
    public boolean controllerCadastrarOP(OrcamentoProduto op){
        return opDAO.cadastrarOrcamentoProdutoDAO(op);
    }
    
    public boolean controllerAtualizarOP(OrcamentoProduto op){
        return opDAO.atualizarOrcamentoProdutoDAO(op);
    }
    
    public boolean controllerExcluirOP(int id){
        return opDAO.deletarOrcamentoProdutoDAO(id);
    }
    
    public ArrayList<OrcamentoProduto> controllerListarOP(){
        return opDAO.ListarOrcamentoProdutoDAO();
    }
    
    public List<OrcamentoProduto> controllerRetornaOrcamento(int id){
        return opDAO.retornaOrcamentoProdutoDAO(id);
    }
    
}
