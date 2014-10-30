package br.com.pizzaria.bean;

public class RequisicaoMercadoriaBean {

    private int codigo;
    private String dataMovimento;
    private int codigoSetor;
    private ProdutoBean produtoBean;
    private int tipoMovimento;
    private long quantidadeMovimento;
    private int codigoFunc;

    public RequisicaoMercadoriaBean() {
        
        produtoBean = new ProdutoBean();
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the quantidadeMovimento
     */
    public long getQuantidadeMovimento() {
        return quantidadeMovimento;
    }

    /**
     * @param quantidadeMovimento the quantidadeMovimento to set
     */
    public void setQuantidadeMovimento(long quantidadeMovimento) {
        this.quantidadeMovimento = quantidadeMovimento;
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
     * @return the produtoBean
     */
    public ProdutoBean getProdutoBean() {
        return produtoBean;
    }

    /**
     * @param precoProduto the produtoBean to set
     */
    public void setProdutoBean(ProdutoBean produtoBean) {
        this.produtoBean = produtoBean;
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
     * @return the codigoFunc
     */
    public int getCodigoFunc() {
        return codigoFunc;
    }

    /**
     * @param codigoFunc the codigoFunc to set
     */
    public void setCodigoFunc(int codigoFunc) {
        this.codigoFunc = codigoFunc;
    }

    /**
     * @return the codigoSetor
     */
    public int getCodigoSetor() {
        return codigoSetor;
    }

    /**
     * @param codigoSetor the codigoSetor to set
     */
    public void setCodigoSetor(int codigoSetor) {
        this.codigoSetor = codigoSetor;
    }

}
