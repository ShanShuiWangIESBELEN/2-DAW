package org.iesbelen.anotaciones;

public class CredencialClass {

    private String usuario;
    private String hashPasswd;

    public CredencialClass(String usuario, String hashPasswd) {
        this.usuario = usuario;
        this.hashPasswd = hashPasswd;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getHashPasswd() {
        return hashPasswd;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setHashPasswd(String hashPasswd) {
        this.hashPasswd = hashPasswd;
    }
}
