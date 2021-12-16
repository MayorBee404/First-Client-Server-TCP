package com.Server_App;

import com.Client_App.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    private ServerSocket serverSocket;

    public Server1(ServerSocket serverSocket){
        this.serverSocket = serverSocket;

    }
    public void startServer(){
        try{
            while (!serverSocket.isClosed()){
                Socket socket =serverSocket.accept();
                System.out.println("Client Sudah Masuk");
                ClientHandler clientHandler = new ClientHandler(socket);

                Thread thread = new Thread(clientHandler);
                thread.start();

            }
        }catch (IOException e){
            System.out.println("Client Tidak Tersambung");

        }
    }
    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main  (String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket (5000);
        Server1 server1 = new Server1(serverSocket);
        System.out.println("Tunggu Client Muncul dengan : "+ serverSocket);
        server1.startServer();
    }
}


