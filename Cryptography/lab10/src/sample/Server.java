package sample;


 import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

 /**
 * Created by ivang on 20.11.2016.
 */
public class Server extends Thread {
    private boolean interupted_flag = false;
    private static final String SEND_DATA = "GET_CAPTURE";
    private DataCollecting dataCollecting;
    DataInputStream in;
    DataOutputStream out;

    public Server(DataCollecting dataCollecting) {
        this.dataCollecting = dataCollecting;
    }

    @Override
    public void run() {
        int port = 9090;
        try {
            ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
            System.out.println("Waiting for a client...");

            Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
            System.out.println();

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            in = new DataInputStream(sin);
            out = new DataOutputStream(sout);

            String line = null;
            while (!interupted_flag) {
                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.

                if (line.equals("Client say Goodbye!"))
                {
                    interupted_flag = true;
                }
                command(line);
                System.out.println("The dumb client just sent me this line : " + line);
                System.out.println("Waiting for the next line...");
                System.out.println();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
    public void command(String command) {
        switch (command){
            case SEND_DATA:
                try {
                    out.writeUTF(dataCollecting.getData());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
