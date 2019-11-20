import javafx.animation.ScaleTransition;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.spec.KeySpec;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MessageDigest sha = null;
        SecretKeySpec secretKey;
        try {
            byte[] key = "AAAAAAAAAAAAAA".getBytes();
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key,16);
            secretKey = new SecretKeySpec(key, "AES");
            Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, secretKey);
            InputStream file = new FileInputStream(System.getProperty("user.dir")+"/assets/imagemparacifrar.jpg");
            byte[] arquivoCifrado = c.doFinal(file.readAllBytes());
            FileOutputStream outputStream = new FileOutputStream("questao1.aes");
            outputStream.write(arquivoCifrado);
        }
        catch(Exception e){
          e.printStackTrace();
        }

    }
}
