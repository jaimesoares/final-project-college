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
public class ItemCupomBean {
    private int codigoCupom;//resgatar no processo de registrar o pedido
    private int codigoItem;//auto incremento
    private int codigoProduto;
    private int quantidade;
    private double precoUnitario;
    private double precoTotal;
   // private String meiaPizza;
   // private String descricao;
    private int codigoProduto2;
    private int codigoProduto3;
    private double valotDesconto;

    /**
     * @return the codigoCupom
     */
    public int getCodigoCupom() {
        return codigoCupom;
    }

    /**
     * @param codigoCupom the codigoCupom to set
     */
    public void setCodigoCupom(int codigoCupom) {
        this.codigoCupom = codigoCupom;
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
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
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
     * @return the precoTotal
     */
    public double getPrecoTotal() {
        return precoTotal;
    }

    /**
     * @param precoTotal the precoTotal to set
     */
    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    /**
     * @return the meiaPizza
     */
//    public String getMeiaPizza() {
//        return meiaPizza;
//    }
//
//    /**
//     * @param meiaPizza the meiaPizza to set
//     */
//    public void setMeiaPizza(String meiaPizza) {
//        this.meiaPizza = meiaPizza;
//    }
//    
//    @Override
//    public String toString(){
//        return this.descricao;
//    }
//
//    /**
//     * @return the descricao
//     */
//    public String getDescricao() {
//        return descricao;
//    }
//
//    /**
//     * @param descricao the descricao to set
//     */
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }

    /**
     * @return the codigoProduto2
     */
    public int getCodigoProduto2() {
        return codigoProduto2;
    }

    /**
     * @param codigoProduto2 the codigoProduto2 to set
     */
    public void setCodigoProduto2(int codigoProduto2) {
        this.codigoProduto2 = codigoProduto2;
    }

    /**
     * @return the codigoProduto3
     */
    public int getCodigoProduto3() {
        return codigoProduto3;
    }

    /**
     * @param codigoProduto3 the codigoProduto3 to set
     */
    public void setCodigoProduto3(int codigoProduto3) {
        this.codigoProduto3 = codigoProduto3;
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
}
