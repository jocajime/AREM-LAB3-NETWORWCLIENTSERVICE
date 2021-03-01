package edu.escuelaing.arem.pico;


import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.BiFunction;
public class PicoSpark {

    public static void get(String route, BiFunction<HttpRequest, HttpResponse, String> biFunction){
        PicoSparkServer picoSparkServer = PicoSparkServer.getInstance();
        picoSparkServer.get (route,biFunction);
    }

    public static void port(int port){
        PicoSparkServer picoSparkServer = PicoSparkServer.getInstance ();
        picoSparkServer.port(port);

    }

    public static void startServer() {
        PicoSparkServer picoSparkServer = PicoSparkServer.getInstance ();
        picoSparkServer.startServer ();
    }
}
