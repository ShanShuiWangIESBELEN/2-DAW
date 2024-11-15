package org.iesbelen.anotaciones;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

// usuario: usuario1
// passwd: admin <-> hashPasswd: 8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
@Credencial(usuario = "usuario1",
        hashPasswd = "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918")
// usuario: usuario2
// passwd: admin1234 <-> hashPasswd: ac9689e2272427085e35b9d3e3e8bed88cb3434828b43b86fc0596cad4c6e270
@Credencial(usuario = "usuario2",
        hashPasswd = "ac9689e2272427085e35b9d3e3e8bed88cb3434828b43b86fc0596cad4c6e270")

public class Login {
    private List<CredencialClass> listaCredenciales;
    public Login() {
        listaCredenciales = cargadorDeContexto();
    }
    public static List<CredencialClass> cargadorDeContexto() {
        Credencial[] credencialesAnotacion = login.class.getAnnotationsByType(Credencial.class);
        for (Credencial credencial : credencialesAnotacion) {
        CredencialClass credencialClass = new CredencialClass(credencial.usuario(), credencial.hashPasswd());
        listaCredenciales.add(credencialClass);
        }
        return

        }
    }
    /**
     * Método que obtiene el hash de una password, por ejemplo, dado password = admin, devuelve:
     8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
     * @param password
     * @return hash de encriptación de la password
     * @throws NoSuchAlgorithmException
     */
    public static String hashPassword(String password ) throws NoSuchAlgorithmException {
        MessageDigest digest;

        digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));

        return bytesToHex(encodedhash);
    }

    private static String bytesToHex(byte[] byteHash) {

        StringBuilder hexString = new StringBuilder(2 * byteHash.length);
        for (int i = 0; i < byteHash.length; i++) {
            String hex = Integer.toHexString(0xff & byteHash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public Login() throws NoSuchAlgorithmException { //El throws me lo pone el ide, no se para que es
        login();
    }

    private boolean verificarAcceso(String usuario, String hash) {
        boolean entra = false;
        Credencial[] credenciales = Login.class.getAnnotationsByType(Credencial.class);

        for (Credencial credencial : credenciales) {
            if (credencial.usuario().equals(usuario) && credencial.hashPasswd().equals(hash)) {
                entra = true;
            }
        }

        return entra;
    }

    private void login() throws NoSuchAlgorithmException { // este throws igual
        String usuario, passwd;

        Scanner sc = new Scanner(System.in);
        System.out.print("Dame un usuario: ");
        usuario = sc.nextLine();
        System.out.print("Dame un password: ");
        passwd = sc.nextLine();

        String hash = hashPassword(passwd);
        boolean accedido = verificarAcceso(usuario ,hash);

        if (accedido) {
            System.out.println("ACCESO CONCEDIDO");
        } else {
            System.out.println("ACCESO DENEGADO");
        }
    }
}
