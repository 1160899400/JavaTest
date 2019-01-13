package socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class TCPServer {
    // TCP 服务端套接字
    private ServerSocket serverSocket;

    public TCPServer(int port) throws IOException {
        //初始化server套接字,客户端连接请求的阻塞队列容量默认为50
        serverSocket = new ServerSocket(port);

        //setSoTimeout方法指定连接时阻塞的最大时间，若超出时间，则抛除异常（必须在accept前调用时才会生效）
        //serverSocket.setSoTimeout(10000);
        //accept方法调用后，开始等待连接（当前线程阻塞），若连接上，则返回。

        while (true){
            serverSocket.accept();
            InetAddress inetAddress = serverSocket.getInetAddress();
        }


    }
}
