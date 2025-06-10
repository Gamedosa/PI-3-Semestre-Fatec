package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Orcamento {

    private int idorcamento;
    private String codigo_orcamento;
    private List<Produto> produtos;
    private Cliente cliente;
    private Usuario usuario;
    private Date dataInicio;
    private Date dataTermino;
    private int periodo;
    private double valorLiquido;
    private double valorTotal;
    private double desconto;
    private StatusOrcamento status;
    
    public Orcamento() {
        produtos = new ArrayList<>();
    }

    public Orcamento(int idorcamento, String codigo_orcamento, List<Produto> produtos, Cliente cliente, Usuario usuario, Date dataInicio, Date dataTermino, int periodo, double valorLiquido, double valorTotal, double desconto, StatusOrcamento status) {
        this.idorcamento = idorcamento;
        this.codigo_orcamento = codigo_orcamento;
        this.produtos = produtos;
        this.cliente = cliente;
        this.usuario = usuario;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.periodo = periodo;
        this.valorLiquido = valorLiquido;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.status = status;
    }

    public int getIdorcamento() {
        return idorcamento;
    }

    public void setIdorcamento(int idorcamento) {
        this.idorcamento = idorcamento;
    }

    public String getCodigo_orcamento() {
        return codigo_orcamento;
    }

    public void setCodigo_orcamento(String codigo_orcamento) {
        this.codigo_orcamento = codigo_orcamento;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public StatusOrcamento getStatus() {
        return status;
    }

    public void setStatus(StatusOrcamento status) {
        this.status = status;
    }
    
    
    
}
