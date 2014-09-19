package br.com.pizzaria.beans;

public class ProdutoBeans {
    
    private int codigo;
    private String descricao;
    private TipoProdutoBeans tipoProduto;
    private double qtdMinima;
    private char avisaEstoqueMinimo;
    private double qtdSaldoEstoque;
    private char estocavel;
    private String dataCad;
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the tipoProduto
     */
    public TipoProdutoBeans getTipoProduto() {
        return tipoProduto;
    }

    /**
     * @param tipoProduto the tipoProduto to set
     */
    public void setTipoProduto(TipoProdutoBeans tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    
    
    @Override
    public String toString(){
        return this.descricao;
    }

    /**
     * @return the qtdMinima
     */
    public double getQtdMinima() {
        return qtdMinima;
    }

    /**
     * @param qtdMinima the qtdMinima to set
     */
    public void setQtdMinima(double qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    /**
     * @return the avisaEstoqueMinimo
     */
    public char getAvisaEstoqueMinimo() {
        return avisaEstoqueMinimo;
    }

    /**
     * @param avisaEstoqueMinimo the avisaEstoqueMinimo to set
     */
    public void setAvisaEstoqueMinimo(char avisaEstoqueMinimo) {
        this.avisaEstoqueMinimo = avisaEstoqueMinimo;
    }

    /**
     * @return the qtdSaldoEstoque
     */
    public double getQtdSaldoEstoque() {
        return qtdSaldoEstoque;
    }

    /**
     * @param qtdSaldoEstoque the qtdSaldoEstoque to set
     */
    public void setQtdSaldoEstoque(double qtdSaldoEstoque) {
        this.qtdSaldoEstoque = qtdSaldoEstoque;
    }

    /**
     * @return the estocavel
     */
    public char getEstocavel() {
        return estocavel;
    }

    /**
     * @param estocavel the estocavel to set
     */
    public void setEstocavel(char estocavel) {
        this.estocavel = estocavel;
    }

    /**
     * @return the dataCad
     */
    public String getDataCad() {
        return dataCad;
    }

    /**
     * @param dataCad the dataCad to set
     */
    public void setDataCad(String dataCad) {
        this.dataCad = dataCad;
    }

    
}
