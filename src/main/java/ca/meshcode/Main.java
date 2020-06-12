package ca.meshcode;

public class Main {
    public static void main(String[] args) {
        //create an HTTP Server with unique name
        //this is a call to the HTTPServer class in this package
        //Assign the class "HTTPServer" to a variable "freshHTTPServer" and run its constructor HTTPServer()
        HTTPServer freshHTTPServer = new HTTPServer();
        //
        //start the server (a built-in method)
        freshHTTPServer.start();
    }
}
