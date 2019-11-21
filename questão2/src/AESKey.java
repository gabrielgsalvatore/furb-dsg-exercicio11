import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;

public class AESKey {

    public static void main(String[] args) {
        MessageDigest sha = null;
        SecretKeySpec secretKey;
        try {
            InputStream fileKeystore = new FileInputStream(System.getProperty("user.dir")+"/assets/keystores/ks.jks");
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(fileKeystore, "senha".toCharArray());
            Certificate certificate = keyStore.getCertificate("gilvan justino");
            X509Certificate x509cert = (X509Certificate) certificate;
            byte[] publickey = x509cert.getPublicKey().getEncoded();
            sha = MessageDigest.getInstance("SHA-1");
            publickey = sha.digest(publickey);
            publickey = Arrays.copyOf(publickey,16);
            secretKey = new SecretKeySpec(publickey, "AES");
            Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, secretKey);
            InputStream fileKey = new FileInputStream(System.getProperty("user.dir")+"/assets/chavebin");
            byte[] keyCifrada = c.doFinal(fileKey.readAllBytes());
            FileOutputStream outputStream = new FileOutputStream("key.aes");
            outputStream.write(keyCifrada);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
