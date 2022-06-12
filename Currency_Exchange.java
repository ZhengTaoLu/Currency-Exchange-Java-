import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class Currency_Exchange {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, String> Rahaa = new HashMap<>();
        try (Scanner lukija = new Scanner(System.in)) {
            Rahaa.put(1, "EUR");
            Rahaa.put(2, "USD");
            Rahaa.put(3, "CNY");
            Rahaa.put(4, "JPY");
            Rahaa.put(5, "TWD");

            String mistä, minne;
            double määrä;

            System.out.println("Currency converting from? \n");
            System.out.println("1:EUR \t 2:USD \t 3:CNY \t " +
                                "4:JPY \t 5:TWD \n");
            
            System.out.print("Here: ");
            mistä = Rahaa.get(Integer.valueOf(lukija.nextLine()));

            System.out.println("Currency converting to? \n");
            System.out.println("1:EUR \t 2:USD \t 3:CNY \t " +
                                "4:JPY \t 5:TWD \n");
            
            System.out.print("Here: ");                    
            minne = Rahaa.get(Integer.valueOf(lukija.nextLine()));

            System.out.println("Amount? \n");
            määrä = Double.valueOf(lukija.nextLine());
        }


    }
    
    private static void Valuutta(String mistä, String minne, Double määrä) throws IOException{
        
        String url_str = "https://api.exchangerate.host/convert?from=" + mistä +"&to=" + minne;
        
        /** 
        * ! instantiate the URL object with the target URL of the resource to request.
        */
        URL url = new URL(url_str);
        
        /** 
         * ! instantiate the HttpURLConnection with the URL object 
         * ! - A new connection is opened every time by calling the openConnection method of the protocol handler for this URL. 
         * 
         * * 1. This is the point where the connection is opened.
         */                                             
        
        /**
         * ! Why (HttpURLConnection) url.openConnection() insteasd of new HttpURLConnection()?
         * * https://stackoverflow.com/questions/10119067/java-httpurlconnection-class-program
         */
        HttpURLConnection request =  (HttpURLConnection) url.openConnection();
        
        /**
         * ! URL class:
         * The URL class is the gateway to any of the resources available on the internet. 
         * A Class URL represents a Uniform Resource Locator, which is a pointer to a “resource” on the World Wide Web. 
         * A resource can point to a simple file or directory, or it can refer to a more complicated object, such as a query to a database or to a search engine.
         */
        /**
         * ! HttpURLConnection class:
         * An abstract class directly extending from URLConnection class. 
         * It includes all the functionality of its parent class with additional HTTP-specific features.
         */
        
        /** 
         * ! setRequestMethod():
         * Sets the method for the URL request, 
         * one of: "GET","POST","HEAD","OPTIONS","PUT","DELETE","TRACE" are legal, 
         * subject to protocol restrictions.
         */
        request.setRequestMethod("GET");     
        
        /**
         * ! getResponseCode():
         *   Gets the status code from an HTTP response message. 
         * * For example, in the case of the following status lines:
         * ! HTTP/1.0 "200=OK" 
         * ! HTTP/1.0 "401=Unauthorized"  
         * * It will return 200 and 401 respectively. Returns -1 if no code can be discerned from the response
         */
        
        if(request.getResponseCode() == HttpURLConnection.HTTP_OK){
            /** 
             * ! BufferedReader:
             * * It abstracts the low level byte-by-byte reading of files and gives you a much simpler and more convenient interface to reading files.
             * https://www.reddit.com/r/learnprogramming/comments/372kxy/eli5_bufferedreader_vs_scanner_java/
             * ! BufferedReader vs FileReader
             *  https://stackoverflow.com/questions/9648811/specific-difference-between-bufferedreader-and-filereader
             * 
             * * BufferedReader name = new BufferedReader(new "insert inputstreamreader or It's subclass reader")("inputstream");
            */

            /**
             * ! InputStreamReader():
             * 
             */
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuffer response = new StringBuffer();

            while(inputStream.readLine() != null){ // keep reading 
                
            }
        }
    }
}
