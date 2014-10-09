package br.com.pizzaria.bean;

public class PrecoProdutoBean {

    private ProdutoBean produtoBeans;
    private String dataVigencia;
    private double preco;

    public ProdutoBean getProdutoBeans() {
        return produtoBeans;
    }

    /**
     * @param produtoBeans
     */
    public void setProdutoBeans(ProdutoBean produtoBeans) {
        this.produtoBeans = produtoBeans;
    }

    
    public String getDataVigencia() {
        return dataVigencia;
    }

    /**
     * @param dataVigencia
     */
    public void setDataVigencia(String dataVigencia) {
        this.dataVigencia = dataVigencia;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public ProdutoBean toSting(){
        return this.produtoBeans;
    }
    
}
