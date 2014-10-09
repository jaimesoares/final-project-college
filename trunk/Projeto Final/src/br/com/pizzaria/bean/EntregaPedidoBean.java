package br.com.pizzaria.bean;

import java.util.ArrayList;
import java.util.List;

public class EntregaPedidoBean {
    
    private int codigoPedido;
    private int codigoCliente;
    private int codigoFuncionario;
    private int codigoEntregador;
    private String data;
    private String hora;
    private double valorTotalPedido;
    private String status;
    private List<Integer> codProduto;
    private List<Integer> quantidade;
    private List<ProdutoBean> produto;

    public EntregaPedidoBean() {
        codProduto = new ArrayList<>();
        quantidade = new ArrayList<>();
        produto = new ArrayList<>();
    }

    public int getCodProduto(int posicao) {
        return codProduto.get(posicao);
    }

    public void setCodProduto(int codProduto) {
        this.codProduto.add(codProduto);
    }

    public int getQuantidade(int posicao) {
        return getQuantidade().get(posicao);
    }

    public void setQuantidade(int quantidade) {
        this.getQuantidade().add(quantidade);
    }

    /**
     * @return the codigoPedido
     */
    public int getCodigoPedido() {
        return codigoPedido;
    }

    /**
     * @param codigoPedido the codigoPedido to set
     */
    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    /**
     * @return the codigoCliente
     */
    public int getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * @param codigoCliente the codigoCliente to set
     */
    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    /**
     * @return the codigoFuncionario
     */
    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    /**
     * @param codigoFuncionario the codigoFuncionario to set
     */
    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    /**
     * @return the codigoEntregador
     */
    public int getCodigoEntregador() {
        return codigoEntregador;
    }

    /**
     * @param codigoEntregador the codigoEntregador to set
     */
    public void setCodigoEntregador(int codigoEntregador) {
        this.codigoEntregador = codigoEntregador;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the valorTotalPedido
     */
    public double getValorTotalPedido() {
        return valorTotalPedido;
    }

    /**
     * @param valorTotalPedido the valorTotalPedido to set
     */
    public void setValorTotalPedido(double valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString(){
        return codigoPedido+"";
    }

    /**
     * @return the quantidade
     */
    public List<Integer> getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(List<Integer> quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the produto
     */
    public List<ProdutoBean> getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(List<ProdutoBean> produto) {
        this.produto = produto;
    }
    
}
