package restfulservice.config;

import java.io.IOException;
import java.net.ServerSocket;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import mockapp.AppSocketServer;

/**
 *
 * @author Eason Lin
 *
 */
public class WebAppInitializer
  extends AbstractAnnotationConfigDispatcherServletInitializer
{

  /**
   *
   * 這邊模擬起一個socket server，
   * 並可以同時接收muti client socket
   */
  public WebAppInitializer() throws IOException  {
    Runnable socketServerTask = () -> {
    ServerSocket serverSocket = null;
      try {
        serverSocket = new ServerSocket(10008);
        System.out.println("Connection Socket Created");

        while (true)
          new AppSocketServer(serverSocket.accept());

      } catch (IOException e) {
        System.err.println("Accept failed.");
      }

    };
    new Thread(socketServerTask).start();
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/"};
  }

  /**
   * middle-tier and data-tier components.
   */
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] {RootConfig.class};
  }

  /**
   * load beans containing web components such as controllers, view resolvers,
   * and handler mappings.
   */
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] {WebConfig.class};
  }

}
