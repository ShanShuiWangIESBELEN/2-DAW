import org.iesbelen.anotaciones.Credencial;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static sun.security.jgss.GSSUtil.login;

// usuario: usuario1
// passwd: admin <-> hashPasswd: 8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
@Credencial(usuario = "usuario1",
        hashPasswd = "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918")
// usuario: usuario2
// passwd: admin1234 <-> hashPasswd: ac9689e2272427085e35b9d3e3e8bed88cb3434828b43b86fc0596cad4c6e270
@Credencial(usuario = "usuario2",
        hashPasswd = "ac9689e2272427085e35b9d3e3e8bed88cb3434828b43b86fc0596cad4c6e270")

public class Login {
    /**
     * Método que obtiene el hash de una password, por ejemplo, dado password = admin, devuelve:
     * 8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
     *
     * @param password
     * @return hash de encriptación de la password
     * @throws NoSuchAlgorithmException
     */
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
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

    public Login() {
        login();
    }

    public
    private void login() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce usuario: ");
        String user = sc.nextLine();
        System.out.println("Introduce password: ");
        String password = sc.nextLine();
    }
}