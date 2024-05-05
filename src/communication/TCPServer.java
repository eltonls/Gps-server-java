package communication;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private InetAddress host;
    private int port;
    private ServerSocket socket;

    public TCPServer(InetAddress host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() {
        try {
            socket = new ServerSocket(port);
            System.out.println("Server is listening on: " + host + ":" + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String receiveData() {
        try {
            Socket client = socket.accept();
            // Print received data
            byte[] buffer = new byte[1024];
            int length = client.getInputStream().read(buffer);
            System.out.println(new String(buffer, 0, length));

            return new String(buffer, 0, length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ServerSocket getSocket() {
        return socket;
    }

    public void setSocket(ServerSocket socket) {
        this.socket = socket;
    }

    public InetAddress getHost() {
        return host;
    }

    public void setHost(InetAddress host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
