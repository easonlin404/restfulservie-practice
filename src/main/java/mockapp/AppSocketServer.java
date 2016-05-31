package mockapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author Eason Lin
 *
 */
public class AppSocketServer extends Thread
{
 protected Socket clientSocket;

  public AppSocketServer(Socket clientSoc) {
    clientSocket = clientSoc;
    start();
  }

  @Override
  public void run() {
    try {
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
          true);
      BufferedReader in = new BufferedReader(
          new InputStreamReader(clientSocket.getInputStream()));

      String inputLine;

      inputLine = in.readLine();
      //TODO://模擬做事，休息1min
      Thread.sleep(60*1000);
      out.println(inputLine + " " + new Date()); //回傳加上日期

      out.close();
      in.close();
      clientSocket.close();
    } catch (IOException | InterruptedException e) {
      System.err.println("Problem with Communication Server");
    }
  }


}