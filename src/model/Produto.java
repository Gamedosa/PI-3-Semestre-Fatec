package model;

public class Produto {

    private int idproduto;
    private String nome;
    private int quantidade;
    private double preco;
    private byte[] imagem;
    private String observacao;

    public Produto(int idproduto, String nome, int quantidade, double preco, byte[] imagem, String observacao) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.imagem = imagem;
        this.observacao = observacao;
    }

    public Produto() {
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
    
}
