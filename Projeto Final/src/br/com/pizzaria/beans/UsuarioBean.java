package br.com.pizzaria.beans;

public class UsuarioBean {

    private int codigoFuncionario;
    private String login;
    private String senha;
    private char ativoInativo;

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int id_usuario) {
        this.codigoFuncionario = id_usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    @Override
    public String toString(){
        return this.codigoFuncionario+"";
    }

    /**
     * @return the ativoInativo
     */
    public char getAtivoInativo() {
        return ativoInativo;
    }

    /**
     * @param ativoInativo the ativoInativo to set
     */
    public void setAtivoInativo(char ativoInativo) {
        this.ativoInativo = ativoInativo;
    }
}