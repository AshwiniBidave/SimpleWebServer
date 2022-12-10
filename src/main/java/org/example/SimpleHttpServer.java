package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Handler;

public class SimpleHttpServer {
    public static int DEFAULT_PORT=9000;
    public static int port;
    private HttpServer httpserver;
    private void start(int port){
        this.port=port;
        try{
            httpserver= HttpServer.create(new InetSocketAddress(port),0);
            System.out.println("Server started at "+port);
            httpserver.createContext("/", new Handlers.RootHandler());
            httpserver.createContext("/echoHeader", new Handlers.EchoHeaderHandler());
            httpserver.createContext("/echoGet", new Handlers.EchoGetHandler());
            httpserver.createContext("/echoPost", new Handlers.EchoPostHandler());
            httpserver.setExecutor(null);
            httpserver.start();




        }catch(Exception e){
            e.printStackTrace();
        }}
        public static void main(String[] args) {
            SimpleHttpServer httpsServer= new SimpleHttpServer();
            httpsServer.start(DEFAULT_PORT);
        }

}
