package br.com.pizzaria.bean;

import java.util.ArrayList;
import java.util.List;

public class CupomBean {
    
    private int codigoPedido;
   // private Integer codigoCliente;
    //private String loginUsuario;
   // private int codigoEntregador;
    private String data;
    private String hora;
    private double valorTotalCupom;
   // private String status;
  //  private List<Integer> codProduto;
  //  private List<Integer> quantidade;
  //  private String obs;
  //  private double valorDesc;
    private List<ItemCupomBean> itensCupom;
  //  private double valorRecebido;
  //  private double valorTroco;
  //  private String tipoPagamento;
   // private String tipoPedido;

    public CupomBean() {
//        codProduto = new ArrayList<>();
//        quantidade = new ArrayList<>();
        itensCupom = new ArrayList<>();
    }

//    public int getCodProduto(int posicao) {
//        return codProduto.get(posicao);
//    }
//
//    public void setCodProduto(int codProduto) {
//        this.codProduto.add(codProduto);
//    }
//
//    public int getQuantidade(int posicao) {
//        return quantidade.get(posicao);
//    }
//
//    public void setQuantidade(int quantidade) {
//        this.quantidade.add(quantidade);
//    }

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
//    public Integer getCodigoCliente() {
//        return codigoCliente;
//    }
//
//    /**
//     * @param codigoCliente the codigoCliente to set
//     */
//    public void setCodigoCliente(Integer codigoCliente) {
//        this.codigoCliente = codigoCliente;
//    }
//
//    /**
//     * @return the loginUsuario
//     */
//    public String getLoginUsuario() {
//        return loginUsuario;
//    }
//
//    /**
//     * @param loginUsuario the loginUsuario to set
//     */
//    public void setLoginUsuario(String loginUsuario) {
//        this.loginUsuario = loginUsuario;
//    }
//
//    /**
//     * @return the codigoEntregador
//     */
//    public int getCodigoEntregador() {
//        return codigoEntregador;
//    }
//
//    /**
//     * @param codigoEntregador the codigoEntregador to set
//     */
//    public void setCodigoEntregador(int codigoEntregador) {
//        this.codigoEntregador = codigoEntregador;
//    }

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
     * @return the valorTotalCupom
     */
    public double getValorTotalCupom() {
        return valorTotalCupom;
    }

    /**
     * @param valorTotalCupom the valorTotalCupom to set
     */
    public void setValorTotalCupom(double valorTotalCupom) {
        this.valorTotalCupom = valorTotalCupom;
    }

    /**
     * @return the status
     */
//    public String getStatus() {
//        return status;
//    }
//
//    /**
//     * @param status the status to set
//     */
//    public void setStatus(String status) {
//        this.status = status;
//    }
//    
//    @Override
//    public String toString(){
//        return codigoPedido+"";
//    }
//
//    /**
//     * @return the obs
//     */
//    public String getObs() {
//        return obs;
//    }
//
//    /**
//     * @param obs the obs to set
//     */
//    public void setObs(String obs) {
//        this.obs = obs;
//    }
//
//    /**
//     * @return the valorDesc
//     */
//    public double getValorDesc() {
//        return valorDesc;
//    }
//
//    /**
//     * @param valorDesc the valorDesc to set
//     */
//    public void setValorDesc(double valorDesc) {
//        this.valorDesc = valorDesc;
//    }

    /**
     * @return the itensPedido
     */
    public List<ItemCupomBean> getItensPedido() {
        return itensCupom;
    }

    /**
     * @param itensPedido the itensPedido to set
     */
    public void setItensPedido(List<ItemCupomBean> itensPedido) {
        this.itensCupom = itensPedido;
    }

    /**
     * @return the valorRecebido
     */
//    public double getValorRecebido() {
//        return valorRecebido;
//    }
//
//    /**
//     * @param valorRecebido the valorRecebido to set
//     */
//    public void setValorRecebido(double valorRecebido) {
//        this.valorRecebido = valorRecebido;
//    }
//
//    /**
//     * @return the valorTroco
//     */
//    public double getValorTroco() {
//        return valorTroco;
//    }
//
//    /**
//     * @param valorTroco the valorTroco to set
//     */
//    public void setValorTroco(double valorTroco) {
//        this.valorTroco = valorTroco;
//    }
//
//    /**
//     * @return the tipoPagamento
//     */
//    public String getTipoPagamento() {
//        return tipoPagamento;
//    }
//
//    /**
//     * @param tipoPagamento the tipoPagamento to set
//     */
//    public void setTipoPagamento(String tipoPagamento) {
//        this.tipoPagamento = tipoPagamento;
//    }
//
//    /**
//     * @return the tipoPedido
//     */
//    public String getTipoPedido() {
//        return tipoPedido;
//    }
//
//    /**
//     * @param tipoPedido the tipoPedido to set
//     */
//    public void setTipoPedido(String tipoPedido) {
//        this.tipoPedido = tipoPedido;
//    }
//    
}
