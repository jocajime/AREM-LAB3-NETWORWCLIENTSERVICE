package edu.escuelaing.arem.pico.demoruntime;

import java.io.*;
import java.net.http.HttpRequest;

import static edu.escuelaing.arem.pico.PicoSpark.*;

public class DemoRuntime {

    public static void main(String[] args) {
        port (getPort());
        get("/hello", (req,resp) ->basePage ());
        get("/prueba.html", (req,resp) ->mostrarRecurso("prueba.html"));
        get("/eci.png", (req,resp) ->mostrarRecurso("eci.png"));


        startServer ();
    }

    private static String mostrarRecurso(String recurso)  {
        try {
            if (!(recurso.endsWith (".jpeg") || recurso.endsWith (".jpg") || recurso.endsWith (".png"))) {
                StringBuilder resultado = new StringBuilder ();
                String line;
                BufferedReader bufferedReader = new BufferedReader (new FileReader ("src/main/resources/" + recurso));
                while ((line = bufferedReader.readLine ()) != null) {
                    resultado.append (line);
                }
                bufferedReader.close ();
                return resultado.toString ();
            } else{
                return "<IMG SRC=\"src/main/resources/eci.png\" />";
            }
        }catch (Exception e){
            return basePage ()+"error";
        }


    }

    private static String basePage(){
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Buscador de recursos</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>para encontrar algun recurso, simplemente añada al url /Apps/\"nombre del recurso\".\"extension\"</h1>\n"
                + "<h1> tenemos disponibles eci.png,prueba.html<h1>\n"
                + "</body>\n"
                + "</html>\n";
    }

    private static int getPort() {
        if (System.getenv ("PORT") != null){
            return Integer.parseInt (System.getenv ("PORT"));
        }
        return 36000;
    }
}

