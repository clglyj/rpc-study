package com.study.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {


    private static ExecutorService executorService = Executors.newFixedThreadPool(100);


    public static  void  startService(int port)  throws IOException{
        ServerSocket ss = new ServerSocket(port);
        while (true){
            Socket socket = ss.accept();
            executorService.submit(new RPCThreadProcessor(socket));
        }


    }

}
