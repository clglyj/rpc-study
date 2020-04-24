package com.study.net;

import java.io.IOException;

public class BootStrap {
    public static void main(String[] args) {

        try {
            BIOServer.startService(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
