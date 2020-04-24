package com.study;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class BIOClient {

    public  static   Object  callRemorte(String host,int port,Object  obj){
        //TODO 进行流的处理
        ObjectInputStream ois =  null ;
        ObjectOutputStream oos =  null ;
        Object result = null ;
        try {
            Socket socket = new Socket(host, port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(obj);
            oos.flush();

            ois = new ObjectInputStream(socket.getInputStream());
            result = ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result  ;
    }
}
