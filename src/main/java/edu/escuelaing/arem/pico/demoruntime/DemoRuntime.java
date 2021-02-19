package edu.escuelaing.arem.pico.demoruntime;

import static edu.escuelaing.arem.pico.PicoSpark.*;

public class DemoRuntime {
    public static void main(String[] args) {
        port (getPort());
        get("/hello", (req,resp) ->"Hello World!");

        startServer ();
    }

    private static int getPort() {
        if (System.getenv ("PORT") != null){
            return Integer.parseInt (System.getenv ("PORT"));
        }
        return 36000;
    }
}

