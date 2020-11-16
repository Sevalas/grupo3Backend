package grupo3.adopcionPF;

import grupo3.adopcionPF.resources.mailApi;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class test {
    public static void main(String[] args) throws AddressException {
        new mailApi().enviarConGMail(new InternetAddress("svlandroid@gmail.com"), "test", "test");
    }

}
