package controller;

import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ControllerProduto {

    private final ProdutoDAO produtoDAO;

    public ControllerProduto() {
        this.produtoDAO = new ProdutoDAO();
    }

    public boolean controllerCadastrarProduto(Produto produto) {
        return produtoDAO.cadastrarProdutoDAO(produto);
    }

    public boolean controllerAtualizarProduto(Produto produto) {
        return produtoDAO.atualizarProdutoDAO(produto);
    }

    public boolean controllerExcluirProduto(int id) {
        return produtoDAO.excluirProdutoDAO(id);
    }

    public Produto controllerRetonaProduto(int id) {
        return produtoDAO.retornaProdutoDAO(id);
    }

    public ArrayList<Produto> controllerListaProduto() {
        return produtoDAO.listaProdutoDAO();
    }
    
    public List<Produto> ControllerRetornaProdutoPelnoNome(String nome){
        List<Produto> produtos = new ArrayList<>();
        Produto produto = produtoDAO.retornaProdutoPeloNomeDAO(nome);
        if(produto != null){
            produtos.add(produto);
        }
        return produtos;
    }

}
