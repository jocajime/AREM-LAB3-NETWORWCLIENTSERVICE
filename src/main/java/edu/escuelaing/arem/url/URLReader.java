package edu.escuelaing.arem.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class URLReader {
    public static void main(String[] args) {
        ejercicioUno();
        ejercicioDos();
    }

    /**
     * Imprime en pantalla cada parte de la url
     */
    public static void ejercicioUno() {
        try {
            URL url = new URL("https://www.youtube.com/watch?v=MP_XYEjbKm0#ref");
            System.out.println(url.getProtocol());
            System.out.println(url.getAuthority());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getPath());
            System.out.println(url.getQuery());
            System.out.println(url.getFile());
            System.out.println(url.getRef());
        }catch (MalformedURLException m){
            System.out.println("error en la URL");
        }
    }


    /**
     * Realiza la lectura de una url para guardar en html y luego abrir en un navegador
     */
    public static void  ejercicioDos(){
        //Lectura de URL
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduzca una URL valida");
        String urluser = null;
        try {
            urluser = reader.readLine();
        } catch (IOException e) {
            System.out.println("error");
        }
        //URL
        try {
            URL url = new URL(urluser);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            PrintWriter printWriter = new PrintWriter("prueba.html");
            String line = reader.readLine();
            while(line != null){
                printWriter.write(line);
                line = reader.readLine();
            }
            printWriter.close();
            String os = System.getProperty("os.name");
            if (os.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "prueba.html");
            } else if (os.startsWith("Mac OS X")) {
                Runtime.getRuntime().exec("open -a safari " + "prueba.html");
            } else {
                System.out.println("Please open a browser and go to "+ url);
            }
        } catch (MalformedURLException e) {
            System.out.println("error en url");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
