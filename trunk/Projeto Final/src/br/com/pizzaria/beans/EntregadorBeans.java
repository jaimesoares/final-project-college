package br.com.pizzaria.beans;

public class EntregadorBeans {
    
    private int codigo;
    private String nome;
    private String status;
    private String dataCad;
    private String permissao;

    public EntregadorBeans() {        
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataCad() {
        return dataCad;
    }

    public void setDataCad(String dataCad) {
        this.dataCad = dataCad;
    }

    /**
     * @return the permissao
     */
    public String getPermissao() {
        return permissao;
    }

    /**
     * @param permissao the permissao to set
     */
    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
    
    
}
