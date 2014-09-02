package br.com.pizzaria.beans;

public class UsuarioBeans {

    private int codigo;
    private String usuario;
    private String senha;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int id_usuario) {
        this.codigo = id_usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public String toString(){
        return this.codigo+"";
    }
}