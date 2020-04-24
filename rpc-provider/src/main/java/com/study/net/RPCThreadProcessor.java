package com.study.net;

import com.study.dispatch.ServiceDispatch;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RPCThreadProcessor implements Runnable {

    private Socket socket;

    public RPCThreadProcessor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //TODO 进行流的处理
        ObjectInputStream  ois =  null ;
        ObjectOutputStream oos =  null ;
        try {
            //TODO 获取对象流,因为需要从网络中读取到内存，则需要使用输入流
            ois = new ObjectInputStream(socket.getInputStream());
            Object reqObject = ois.readObject();

            //TODO  根据入参数据调用接口
            Object result = ServiceDispatch.dispatch(reqObject);

            //TODO 将接口返回数据从内存返回给网络socket，需要写入到输出流
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(result);

            oos.flush();

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



    }
}
