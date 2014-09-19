package br.com.pizzaria.beans;

public class PrecoProdutoBeans {

    private ProdutoBeans produtoBeans;
    private String dataVigencia;
    private double preco;

    public ProdutoBeans getProdutoBeans() {
        return produtoBeans;
    }

    /**
     * @param produtoBeans
     */
    public void setProdutoBeans(ProdutoBeans produtoBeans) {
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
    
    public ProdutoBeans toSting(){
        return this.produtoBeans;
    }
    
}
