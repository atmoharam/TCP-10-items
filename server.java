import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;

public class Server {
    Server() {
        try (ServerSocket Server = new ServerSocket(22000)) {
            //listen
            Socket client = Server.accept();
            DataInputStream clientReadSource = new DataInputStream(client.getInputStream());
            DataOutputStream clientWriteSource = new DataOutputStream(client.getOutputStream());

            clientWriteSource.writeUTF("You are connected but not for long");
            clientWriteSource.writeUTF("you can ask me for 10 times ");

            int[] arr = new int[ 10 ];
            for (int i = 0; i < 10; i++) {
                arr[ i ] = clientReadSource.readInt();
            }
            Arrays.sort(arr);
            clientWriteSource.writeUTF("your data in ascending order");
            for (int i = 0; i < 10; i++) {
                clientWriteSource.writeInt(arr[ i ]);
                System.out.println("element number " + (i + 1) + "  is " + arr[ i ]);
            }

            clientWriteSource.writeUTF("your data in descending order");
            for (int i = 9; i >= 0; i--) {
                clientWriteSource.writeInt(arr[ i ]);
                System.out.println("element number " + (10-i) + "  is " + arr[ i ]);
            }
            clientWriteSource.writeUTF("We have no services right now, goodbye");
            clientWriteSource.close();
            clientReadSource.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
