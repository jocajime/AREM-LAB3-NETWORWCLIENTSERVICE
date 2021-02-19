package edu.escuelaing.arem.pico;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

public interface Processor {
    public  String handle(String path, HttpRequest req, HttpResponse resp);
}
