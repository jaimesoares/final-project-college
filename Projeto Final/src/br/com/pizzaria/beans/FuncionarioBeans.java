package br.com.pizzaria.beans;

public class FuncionarioBeans {
    
    private int codigo;
    private String nome;
    private String cargo;
    private String permissao;
    private String dataCad;
    private int cep;
    private int numero;
    private String email;
    private String telCelular;
    private String dataDemissao;
    private String cpf;
    private String rg;
    private String telefone;
    private double salario;
    private String ctps;
    private int codEmpresa;
    private double valeRefeicao;
    private double valeTrans;
    

    public FuncionarioBeans() {        
        
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public String getDataCad() {
        return dataCad;
    }

    public void setDataCad(String dataCad) {
        this.dataCad = dataCad;
    }
    
    @Override
    public String toString(){
        return this.codigo+"";
    }

    /**
     * @return the cep
     */
    public int getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(int cep) {
        this.cep = cep;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telCelular
     */
    public String getTelCelular() {
        return telCelular;
    }

    /**
     * @param telCelular the telCelular to set
     */
    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    /**
     * @return the dataDemissao
     */
    public String getDataDemissao() {
        return dataDemissao;
    }

    /**
     * @param dataDemissao the dataDemissao to set
     */
    public void setDataDemissao(String dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the ctps
     */
    public String getCtps() {
        return ctps;
    }

    /**
     * @param ctps the ctps to set
     */
    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    /**
     * @return the codEmpresa
     */
    public int getCodEmpresa() {
        return codEmpresa;
    }

    /**
     * @param codEmpresa the codEmpresa to set
     */
    public void setCodEmpresa(int codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    /**
     * @return the valeRefeicao
     */
    public double getValeRefeicao() {
        return valeRefeicao;
    }

    /**
     * @param valeRefeicao the valeRefeicao to set
     */
    public void setValeRefeicao(double valeRefeicao) {
        this.valeRefeicao = valeRefeicao;
    }

    /**
     * @return the valeTrans
     */
    public double getValeTrans() {
        return valeTrans;
    }

    /**
     * @param valeTrans the valeTrans to set
     */
    public void setValeTrans(double valeTrans) {
        this.valeTrans = valeTrans;
    }
    
    
}
