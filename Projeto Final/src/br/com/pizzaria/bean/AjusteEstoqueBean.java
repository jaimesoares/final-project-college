package br.com.pizzaria.bean;

public class AjusteEstoqueBean {

    private int codigo;
    private String dataMovimento;
    private ProdutoBean produtoBean;
    private int tipoMovimento;
    private long ajusteMovimento;
    private int codigoFunc;

    public AjusteEstoqueBean() {
        
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
     * @return the ajusteMovimento
     */
    public long getAjusteMovimento() {
        return ajusteMovimento;
    }

    /**
     * @param ajusteMovimento the ajusteMovimento to set
     */
    public void setAjusteMovimento(long ajusteMovimento) {
        this.ajusteMovimento = ajusteMovimento;
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

}
