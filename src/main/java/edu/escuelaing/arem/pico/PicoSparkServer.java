package edu.escuelaing.arem.pico;

import edu.escuelaing.arem.header.headerHttp;
import edu.escuelaing.arem.server.HttpServer;


import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

class PicoSparkServer implements Processor {
    private static PicoSparkServer _instance = new PicoSparkServer ();
    private int httpPort = 36000;
    Map<String, BiFunction<HttpRequest, HttpResponse, String>> functions = new HashMap<String, BiFunction<HttpRequest, HttpResponse, String>> ();
    HttpServer httpServer = new HttpServer ();


    private PicoSparkServer(){
        httpServer.registerProcessor("/Apps" , this);
    }

    public static PicoSparkServer getInstance() {
        return _instance;
    }


    public void get(String route, BiFunction<HttpRequest, HttpResponse, String> biFunction){
        functions.put (route,biFunction);
    }
    public void startServer(){
        try {
            httpServer.startServer(httpPort);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public void port(int serverPort) {
        this.httpPort =serverPort;
    }

    @Override
    public String handle(String path,HttpRequest req, HttpResponse resp) {
        headerHttp headerHttp = new headerHttp ();
        if(functions.containsKey (path)){
            switch (path.substring (path.indexOf ("."))) {
                case ".css":
                    return headerHttp.validOkHttpHeadercss () + functions.get (path).apply (req,resp);
                case ".js":
                    return headerHttp.validOkHttpHeaderjs () + functions.get (path).apply (req,resp);
                case ".json":
                    return headerHttp.validOkHttpHeaderjson () + functions.get (path).apply (req,resp);
                case ".jpeg":
                    return headerHttp.validOkHttpHeaderjpeg () + functions.get (path).apply (req,resp);
                case ".png":
                    return headerHttp.validOkHttpHeaderpng () + functions.get (path).apply (req,resp);
                default:

                    return headerHttp.validOkHttpHeaderhtml () + functions.get (path).apply (req,resp);
            }
        }
        return headerHttp.validErrorHttpHeaderhtml ()+ "Error";
    }

}
