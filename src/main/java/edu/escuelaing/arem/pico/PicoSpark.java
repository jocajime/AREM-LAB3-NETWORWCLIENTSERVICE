package edu.escuelaing.arem.pico;



import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import java.util.function.BiFunction;
import java.util.function.Supplier;

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
