package model;

public class OrcamentoProduto {

    private int id;
    private int idorcamento;
    private int idproduto;
    private double produtoValor;
    private int quantidade;

    public OrcamentoProduto() {
    }

    public OrcamentoProduto(int id, int idorcamento, int idproduto, double produtoValor, int quantidade) {
        this.id = id;
        this.idorcamento = idorcamento;
        this.idproduto = idproduto;
        this.produtoValor = produtoValor;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdorcamento() {
        return idorcamento;
    }

    public void setIdorcamento(int idorcamento) {
        this.idorcamento = idorcamento;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public double getProdutoValor() {
        return produtoValor;
    }

    public void setProdutoValor(double produtoValor) {
        this.produtoValor = produtoValor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
