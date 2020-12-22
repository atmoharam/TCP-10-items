import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    Client(){
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println(ip);
            Socket other = new Socket(ip , 22000);
            Scanner scan =new Scanner(System.in);

            DataInputStream otherReadSource = new  DataInputStream(other.getInputStream());
            DataOutputStream othertWriteSource = new DataOutputStream(other.getOutputStream());

            String str = " ";
            while(true)
            {
                str = otherReadSource.readUTF();
                System.out.println(str);
                str = otherReadSource.readUTF();
                System.out.println(str);
                if (str.equalsIgnoreCase("Exite")) {
                    break;
                }
                for (int i = 0; i < 10; i++) {
                    int item = scan.nextInt();
                    othertWriteSource.writeInt(item);
                }
                str = otherReadSource.readUTF();
                System.out.println(str);
                for (int i = 0; i < 10; i++) {
                    int item = otherReadSource.readInt();
                    System.out.println(item);
                }
                str = otherReadSource.readUTF();
                System.out.println(str);
                for (int i = 0; i < 10; i++) {
                    int item = otherReadSource.readInt();
                    System.out.println(item);
                }
                str = otherReadSource.readUTF();
                System.out.println(str);

            }

            otherReadSource.close();
            othertWriteSource.close();
            other.close();

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
