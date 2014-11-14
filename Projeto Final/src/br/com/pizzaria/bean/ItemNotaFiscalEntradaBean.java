/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pizzaria.bean;

/**
 *
 * @author katia
 */
public class ItemNotaFiscalEntradaBean {
    private String numNotaFiscal;//resgatar no processo de registrar o pedido
    private int serieNotaFiscal;    
    private int codigoItem;    
    private int codigoProduto;    
    private double quantidade;
    private double precoUnitario;
    private double valotDesconto;    
     private double valorImposto;  
    private String refItemProduto;
    private double precoTotalItem;  
    private double precoTotalNotaFiscalItem;  
    private ProdutoBean itemProdutoBean;

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
     * @return the codigoItem
     */
    public int getCodigoItem() {
        return codigoItem;
    }

    /**
     * @param codigoItem the codigoItem to set
     */
    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    /**
     * @return the codigoProduto
     */
    public int getCodigoProduto() {
        return codigoProduto;
    }

    /**
     * @param codigoProduto the codigoProduto to set
     */
    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    /**
     * @return the quantidade
     */
    public double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the precoUnitario
     */
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    /**
     * @param precoUnitario the precoUnitario to set
     */
    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    /**
     * @return the precoTotalItem
     */
    public double getPrecoTotalItem() {
        return precoTotalItem;
    }

    /**
     * @param precoTotalItem the precoTotalItem to set
     */
    public void setPrecoTotalItem(double precoTotalItem) {
        this.precoTotalItem = precoTotalItem;
    }

    /**
     * @return the refItemProduto
     */
    public String getRefItemProduto() {
        return refItemProduto;
    }

    /**
     * @param refItemProduto the refItemProduto to set
     */
    public void setRefItemProduto(String refItemProduto) {
        this.refItemProduto = refItemProduto;
    }
    
    @Override
    public String toString(){
        return this.itemProdutoBean.getDescricao();
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
     * @return the valotDesconto
     */
    public double getValotDesconto() {
        return valotDesconto;
    }

    /**
     * @param valotDesconto the valotDesconto to set
     */
    public void setValotDesconto(double valotDesconto) {
        this.valotDesconto = valotDesconto;
    }

    /**
     * @return the itemProdutoBean
     */
    public ProdutoBean getItemProdutoBean() {
        return itemProdutoBean;
    }

    /**
     * @param itemProdutoBean the itemProdutoBean to set
     */
    public void setItemProdutoBean(ProdutoBean itemProdutoBean) {
        this.itemProdutoBean = itemProdutoBean;
    }

    /**
     * @return the precoTotalNotaFiscalItem
     */
    public double getPrecoTotalNotaFiscalItem() {
        return precoTotalNotaFiscalItem;
    }

    /**
     * @param precoTotalNotaFiscalItem the precoTotalNotaFiscalItem to set
     */
    public void setPrecoTotalNotaFiscalItem(double precoTotalNotaFiscalItem) {
        this.precoTotalNotaFiscalItem = precoTotalNotaFiscalItem;
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
}
