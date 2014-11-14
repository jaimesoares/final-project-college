package br.com.pizzaria.bean;

import java.util.ArrayList;
import java.util.List;

public class NotaFiscalEntradaBean {
    
    private String numNotaFiscal;
    private int serieNotaFiscal;
    private Integer codigoFornecedor;
    private String dataMovimento;
    private double valorTotalNotaFiscal;
    private double valorTotalProdutosNotaFiscal;
    private double valorDesc;
    private double valorImposto;
    private String dataEmissao;
     private String dataRecebimento;
     private int pedidoCompra;     
    private String loginUsuario;
    private List<ItemNotaFiscalEntradaBean> itensNotaFiscalEntrada;
    
    public NotaFiscalEntradaBean() {        
        itensNotaFiscalEntrada = new ArrayList<>();
    }

   

    /**
     * @return the numNotaFiscal
     */
    public String getNumNotaFiscal() {
        return numNotaFiscal;
    }

    /**
     * @param numNotaFiscal the numNotaFiscal to set
     */
    public void setNumNotaFiscal(String numNotaFiscal) {
        this.numNotaFiscal = numNotaFiscal;
    }

    /**
     * @return the codigoFornecedor
     */
    public Integer getCodigoFornecedor() {
        return codigoFornecedor;
    }

    /**
     * @param codigoFornecedor the codigoFornecedor to set
     */
    public void setCodigoFornecedor(Integer codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    /**
     * @return the loginUsuario
     */
    public String getLoginUsuario() {
        return loginUsuario;
    }

    /**
     * @param loginUsuario the loginUsuario to set
     */
    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    /**
     * @return the pedidoCompra
     */
    public int getPedidoCompra() {
        return pedidoCompra;
    }

    /**
     * @param pedidoCompra the pedidoCompra to set
     */
    public void setPedidoCompra(int pedidoCompra) {
        this.pedidoCompra = pedidoCompra;
    }

    /**
     * @return the dataMovimento
     */
    public String getDataMovimento() {
        return dataMovimento;
    }

    /**
     * @param dataMovimento the dataMovimento to set
     */
    public void setDataMovimento(String dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    /**
     * @return the dataEmissao
     */
    public String getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao the dataEmissao to set
     */
    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    /**
     * @return the valorTotalNotaFiscal
     */
    public double getValorTotalNotaFiscal() {
        return valorTotalNotaFiscal;
    }

    /**
     * @param valorTotalNotaFiscal the valorTotalNotaFiscal to set
     */
    public void setValorTotalNotaFiscal(double valorTotalNotaFiscal) {
        this.valorTotalNotaFiscal = valorTotalNotaFiscal;
    }

    /**
     * @return the dataRecebimento
     */
    public String getDataRecebimento() {
        return dataRecebimento;
    }

    /**
     * @param dataRecebimento the dataRecebimento to set
     */
    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }
    
    @Override
    public String toString(){
        return numNotaFiscal+"";
    }

   

    /**
     * @return the valorDesc
     */
    public double getValorDesc() {
        return valorDesc;
    }

    /**
     * @param valorDesc the valorDesc to set
     */
    public void setValorDesc(double valorDesc) {
        this.valorDesc = valorDesc;
    }

    /**
     * @return the itensNotaFiscalEntrada
     */
    public List<ItemNotaFiscalEntradaBean> getItensNotaFiscalEntrada() {
        return itensNotaFiscalEntrada;
    }

    /**
     * @param itensNotaFiscalEntrada the itensNotaFiscalEntrada to set
     */
    public void setItensNotaFiscalEntrada(List<ItemNotaFiscalEntradaBean> itensNotaFiscalEntrada) {
        this.itensNotaFiscalEntrada = itensNotaFiscalEntrada;
    }

    /**
     * @return the valorImposto
     */
    public double getValorImposto() {
        return valorImposto;
    }

    /**
     * @param valorImposto the valorImposto to set
     */
    public void setValorImposto(double valorImposto) {
        this.valorImposto = valorImposto;
    }

   

    /**
     * @return the serieNotaFiscal
     */
    public int getSerieNotaFiscal() {
        return serieNotaFiscal;
    }

    /**
     * @param serieNotaFiscal the serieNotaFiscal to set
     */
    public void setSerieNotaFiscal(int serieNotaFiscal) {
        this.serieNotaFiscal = serieNotaFiscal;
    }

    /**
     * @return the valorTotalProdutosNotaFiscal
     */
    public double getValorTotalProdutosNotaFiscal() {
        return valorTotalProdutosNotaFiscal;
    }

    /**
     * @param valorTotalProdutosNotaFiscal the valorTotalProdutosNotaFiscal to set
     */
    public void setValorTotalProdutosNotaFiscal(double valorTotalProdutosNotaFiscal) {
        this.valorTotalProdutosNotaFiscal = valorTotalProdutosNotaFiscal;
    }
    
}
