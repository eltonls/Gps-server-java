import business.DataHandler;
import business.DataHandlerImpl;
import business.LocalizationReceiver;
import business.LocalizationReceiverImpl;
import communication.TCPServer;
import model.DataRead;

import java.net.InetAddress;
import java.net.UnknownHostException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            InetAddress host = InetAddress.getLocalHost();
            TCPServer tcpServer = new TCPServer(host, 8080);
            DataHandler<DataRead, String> dataHandler = new DataHandlerImpl();

            LocalizationReceiver<String> lc = new LocalizationReceiverImpl(tcpServer, dataHandler);
            lc.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}