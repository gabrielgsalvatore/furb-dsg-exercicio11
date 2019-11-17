import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            InputStream file = new FileInputStream(System.getProperty("user.dir")+"/assets/keystores/ks.jks");
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(file, "senha".toCharArray());
            ArrayList<Certificate> certificados = new ArrayList<>();
            Certificate certificate1 = keyStore.getCertificate("gilvan justino");
            certificados.add(certificate1);
            Certificate certificate2 = keyStore.getCertificate("*.furb.br (icpedu)");
            certificados.add(certificate2);
            Certificate certificate3 = keyStore.getCertificate("www.angeloni.com.br (go daddy secure certificate authority - g2)");
            certificados.add(certificate3);
            Certificate certificate4 = keyStore.getCertificate("www.guiadoestudante.abril.com.br (let's encrypt authority x3)");
            certificados.add(certificate4);
            for(Certificate certificado : certificados){
                X509Certificate x509cert = (X509Certificate) certificado;
                StringBuilder result = new StringBuilder();
                String[] split = x509cert.getSubjectDN().toString().split(",");
                for (String s : split){
                    if(s.contains("CN=")){
                        result.append("Proprietário:").append(s.substring(s.lastIndexOf("=") + 1)).append(" ");
                    }
                    else if(s.contains("OU=")){
                        result.append("Emissor:").append(s.substring(s.lastIndexOf("=") + 1)).append(" ");
                    }
                }
                if(x509cert.getSubjectDN().equals(x509cert.getIssuerDN())){
                    result.append("Self-Signed: Sim");
                }
                else{
                    result.append("Self-Signed: Não");
                }
                System.out.println(result.toString());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
