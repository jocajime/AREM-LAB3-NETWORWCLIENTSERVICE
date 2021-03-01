package edu.escuelaing.arem.pico;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface Processor {

    String handle(String path, HttpRequest req, HttpResponse resp);
}
