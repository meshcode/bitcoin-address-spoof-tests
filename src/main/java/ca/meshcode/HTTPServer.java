package ca.meshcode;

//Example 5.13 HTTP Server
import java.io.*;
import java.net.*;

public class HTTPServer {
    protected void start() {
        ServerSocket s;

        System.out.println("Starting up HTTP Server...");
        try {
            s = new ServerSocket(8088);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return;
        }

        System.out.println("Waiting... ");
        for (;;) {
            try {
                Socket remote = s.accept();
                System.out.println("Connected....");
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        remote.getInputStream()));
                PrintWriter out = new PrintWriter(remote.getOutputStream());

                String str = ".";
                while (!str.equals("")){
                    str = in.readLine();
                    System.out.println(str);
                }
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/html");
                out.println("Server: Java HTTP Server");
                out.println("");
                // Send the HTML page
               // out.println("<H1>Hello World!</H1>");

                out.println("<!DOCTYPE html>   \n" +
                        "<html>   \n" +
                        "<head>  \n" +
                        "<title>Public Bitcoin Address Display</title>  \n" +
                        "<style>   \n" +
                        "Body {  \n" +
                        "  font-family: Calibri, Helvetica, sans-serif;  \n" +
                        "  background-color: black;  \n" +
                        "  color: white;  \n" +
                        "}  \n" +
                        ".BitcoinAddressDIV { \n" +
                        "  text-align: center;  \n" +
                        "}  \n" +
                        "</style>   \n" +
                        "</head>    \n" +
                        "<body>    \n" +
                        "    <div class='BitcoinAddressDIV'><h1>13uMuecDkSEps8kGhh1BpVdAHafsEQnqeY</h1></div>  \n" +
                        "</body>     \n" +
                        "</html>  ");

                        out.flush();
                remote.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }

}