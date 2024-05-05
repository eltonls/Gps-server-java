package business;

import communication.TCPServer;
import model.DataRead;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LocalizationReceiverImpl implements LocalizationReceiver<String>{
    private final TCPServer server;
    private final DataHandler<DataRead, String> dataHandler;
    public LocalizationReceiverImpl(TCPServer server, DataHandler<DataRead, String> dataHandler) {
        this.server = server;
        this.dataHandler = dataHandler;
    }

    @Override
    public String start() {
        server.connect();

        ServerSocket serverSocket = server.getSocket();

        while(true) {
            try {
                System.out.println("Waiting for client...");
                Socket client = serverSocket.accept();
                byte[] buffer = new byte[1024];
                int length = client.getInputStream().read(buffer);
                String msg = new String(buffer, 0, length);
                new Thread(() -> dataHandler.treatData(msg)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
