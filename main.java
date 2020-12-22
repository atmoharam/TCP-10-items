import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        if (scan.next().equals("server"))
        {

            Server s = new Server();
            //code server
        }
        else
            {

            //code client
            Client c;
            c = new Client();
        }
    }

}
