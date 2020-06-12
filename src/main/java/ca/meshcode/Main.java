/*
PROGRAM: A Java HTTP Server with HTML CSS content which contains a Bitcoin Address
AIM: To test the integrity of the Bitocin address using specialized automated processes
WHY: Because it is easy to perform an MITM attack these days and spoof addresses.
Good to have the knowledge to perform automated verification on one's own web service.

AUTHOR: Mateusz Kujawski
DATE: Early June 2020
 */
//package
package ca.meshcode;
//main class
public class Main {
    //main function
    public static void main(String[] args) {
        //create an HTTP Server object with unique name
        //this is a call to the HTTPServer class in this package
        //Assign the class "HTTPServer" to an instance/variable "freshHTTPServer" and run its constructor HTTPServer()
        HTTPServer freshHTTPServer = new HTTPServer();
        //
        //start the server (a built-in method)
        freshHTTPServer.start();
    }
}
