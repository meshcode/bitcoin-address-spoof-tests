//same package as main function
package ca.meshcode;


//imports the networking libraries
import java.io.*;
import java.net.*;

//
//Comments, formatting and revision with bitcoin address idea by MK
//Based on an example from an excellent source by master Perry Xiao
//
//Main Class
public class HTTPServer {
    //the constructor
    protected void start() {
        //create a new socket
        ServerSocket s;
        //turn on the server
        System.out.println("Flipped the ON switch for Gangsta HTTP server.");
        //start the process
        try {
            //create the new socket on designated port
            s = new ServerSocket(8088);
            //catch any issues
        } catch (Exception e) {
            //report error if not possible to create the socket
            System.out.println("Dang Error when creating socket: " + e);
            //step out of the try
            return;
        }

        System.out.println("... ");
        //[!! MAKE BETTER] play an infinite loop to listen to incoming connection
        for (;;) {
            //try the
            try {
                //accept a connection as "remote" when incoming client
                Socket remote = s.accept();
                //report connection to console
                System.out.println("ZAP. Connected.");
                //
                //MAIN I/O CONNECTION PART
                //Create input stream "in"
                BufferedReader in = new BufferedReader(new InputStreamReader(remote.getInputStream()));
                //Create output stream "out"
                PrintWriter out = new PrintWriter(remote.getOutputStream());
                //
                //create a dot string
                String str = ".";
                //[!! MAKE BETTER] - loop while this string is not empty space
                while (!str.equals("")){
                    //read a line from the incoming stream
                    str = in.readLine();
                    //report this line to the console
                    System.out.println("Incoming data line from client: " + str);
                }
                //output to the client:
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/html");
                out.println("Server: Java HTTP Server");
                //the client will probably stop reading once it gets this empty nullish line
                out.println("");
                //
                // Send the HTML page
                //out.println("<H1>Hello World!</H1>");
                //
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
                        //
                        //send it all to the out door
                        out.flush();
                //close the connection once it received all this
                //in this way possibly because it's one thread it can then take more after it closes (?)
                remote.close();

            } catch (Exception e) {
                System.out.println("DANG Error, could not do the I/O thing: " + e);
            }
        }
    }

}