package br.com.pizzaria.beans;

import java.util.ArrayList;
import java.util.List;

public class EntregaPedidoBeans {
    
    private int codigoPedido;
    private int codigoCliente;
    private int codigoFuncionario;
    private int codigoEntregador;
    private String data;
    private String hora;
    private double valor;
    private String status;
    private List<Integer> codProduto;
    private List<Integer> quantidade;

    public EntregaPedidoBeans() {
        codProduto = new ArrayList<>();
        quantidade = new ArrayList<>();
    }

    public int getCodProduto(int posicao) {
        return codProduto.get(posicao);
    }

    public void setCodProduto(int codProduto) {
        this.codProduto.add(codProduto);
    }

    public int getQuantidade(int posicao) {
        return quantidade.get(posicao);
    }

    public void setQuantidade(int quantidade) {
        this.quantidade.add(quantidade);
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
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
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
    
}
