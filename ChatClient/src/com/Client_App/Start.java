package com.Client_App;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Start {
    public Start() {

    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Isi Nama Panggilan anda untuk masuk ke Groub Chat : ");
        String username = scanner.nextLine();
        System.out.print("Pilih Room Chat Grub anda  1 atau 2  : ");
        int room = scanner.nextInt();

        if (room <= 1) {
            System.out.println("ROOM Chat 1");
            Socket socket1 = new Socket("localhost", 5000);
            Client client1 = new Client(socket1, username);
            client1.listenForMessage();
            client1.sendMessage();


        } else  {
            System.out.println("ROOM Chat 2");
            Socket socket2 = new Socket("localhost", 2222);
            Client client2 = new Client(socket2, username);
            client2.listenForMessage();
            client2.sendMessage();


        }

    }
}