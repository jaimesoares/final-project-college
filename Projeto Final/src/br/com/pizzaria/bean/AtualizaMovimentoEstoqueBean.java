/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.bean;

/**
 *
 * @author Jaime
 */
public class AtualizaMovimentoEstoqueBean {

    private String dataMovimento;
    private ProdutoBean produtoBean;
    private int tipoMovimento;
    private long quantidadeProduto;
    private int numeroDocumento;

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
     * @return the tipoMovimento
     */
    public int getTipoMovimento() {
        return tipoMovimento;
    }

    /**
     * @param tipoMovimento the tipoMovimento to set
     */
    public void setTipoMovimento(int tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    /**
     * @return the quantidadeProduto
     */
    public long getQuantidadeProduto() {
        return quantidadeProduto;
    }

    /**
     * @param quantidadeProduto the quantidadeProduto to set
     */
    public void setQuantidadeProduto(long quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    /**
     * @return the numeroDocumento
     */
    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param numeroDocumento the numeroDocumento to set
     */
    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return the produtoBean
     */
    public ProdutoBean getProdutoBean() {
        return produtoBean;
    }

    /**
     * @param produtoBean the produtoBean to set
     */
    public void setProdutoBean(ProdutoBean produtoBean) {
        this.produtoBean = produtoBean;
    }

}
