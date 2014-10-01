package br.com.pizzaria.beans;

public class FuncionarioBean {

    private int codigo;
    private String nome;
    private CargoBean cargo;
    private String permissao;
    private String dataCad;
    private String cep;
    private int numero;
    private String email;
    private String telCelular;
    private String dataDemissao;
    private String cpf;
    private String rg;
    private String telefone;
    private double salario;
    private String estado;
    private int codEmpresa;
    private double valeRefeicao;
    private double valeTrans;
    private String cidade;
    private String rua;
    private String bairro;
    private String nascimento;
    private String moto;
    private String placaMoto;
    private String cnh;
    private UsuarioBean usuarioBeans;

    public FuncionarioBean() {
        cargo = new CargoBean();
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

    public CargoBean getCargo() {
        return cargo;
    }

    public void setCargo(CargoBean cargo) {
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
    public String toString() {
        return this.nome;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
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
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
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

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the nascimento
     */
    public String getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the moto
     */
    public String getMoto() {
        return moto;
    }

    /**
     * @param moto the moto to set
     */
    public void setMoto(String moto) {
        this.moto = moto;
    }

    /**
     * @return the placaMoto
     */
    public String getPlacaMoto() {
        return placaMoto;
    }

    /**
     * @param placaMoto the placaMoto to set
     */
    public void setPlacaMoto(String placaMoto) {
        this.placaMoto = placaMoto;
    }

    /**
     * @return the cnh
     */
    public String getCnh() {
        return cnh;
    }

    /**
     * @param cnh the cnh to set
     */
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    /**
     * @return the usuarioBeans
     */
    public UsuarioBean getUsuarioBeans() {
        return usuarioBeans;
    }

    /**
     * @param usuarioBeans the usuarioBeans to set
     */
    public void setUsuarioBeans(UsuarioBean usuarioBeans) {
        this.usuarioBeans = usuarioBeans;
    }

}
