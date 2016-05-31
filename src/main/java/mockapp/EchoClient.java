package mockapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Eason Lin
 *
 */
public class EchoClient {
  private String host = "127.0.0.1";
  private int port = 10008;
  public String sayHello(String name) throws IOException {

    Socket echoSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;

    echoSocket = new Socket(host, port);
    out = new PrintWriter(echoSocket.getOutputStream(), true);
    in = new BufferedReader(new InputStreamReader(
        echoSocket.getInputStream()));

    out.println(name);

    String msg =  in.readLine();

    out.close();
    in.close();
    echoSocket.close();

    return msg;
  }

  public static void main(String[] args) throws IOException {


  }
}

