import java.util.Currency;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.neovisionaries.i18n.CountryCode;
import com.neovisionaries.i18n.CurrencyCode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
    public static HashMap<String, String[]> Rahaa(){
        HashMap<String, String[]> Rahaa = new HashMap<String,String[]>();

        for(Locale locale: Locale.getAvailableLocales()){
            String[] acctyp = new String[2];

            Currency currency = null;
            try {
                currency = Currency.getInstance(locale);
            } catch (IllegalArgumentException e) {
                continue;
            }

            acctyp[0] = currency.getCurrencyCode();
            acctyp[1] = currency.getDisplayName();
            Rahaa.put(locale.getDisplayCountry(), acctyp);
        }
        return Rahaa;
    }
    public void GUI(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("JavaFX_GUI.fxml"));
            Parent root = (Parent)fxmlLoader.load();
            Scene scene = new Scene(root);

            primaryStage.setTitle("Test");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        // https://www.youtube.com/watch?v=Kmgo00avvEw
        // 1. JFrame = a GUI wi        // 1. Make frame visiblendow to add components to
        JFrame frame = new JFrame();              // 1. Creates a frame

        frame.setTitle("JFrame title");    // 1. Sets title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 1. Exit out of application
        //frame.setResizable(true);  // 1. Prevent frame from being resized
        frame.setSize(420, 420);  // 1. Sets the X-dimension, and Y-dimension of frame
        frame.setVisible(true);
        //ImageIcon image = new ImageIcon();  // 1. Create an ImageIcon
        //frame.setIconImage(image.getImage()); // 1. Change Icon of frame
        frame.getContentPane().setBackground(Color.GREEN); // 1. Change color of background
        */
    }

    public static void Valuutta(String mistä, String minne, Double määrä) throws IOException{
        String url_str = "https://api.exchangerate.host/convert?from=" + mistä +"&to=" + minne;
        DecimalFormat df = new DecimalFormat("00.00");

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
            String inputline;
            /**
             * ! StringBuffer
             *
             */
            StringBuffer response = new StringBuffer();     // Kind of similar to StringBuilder

            while((inputline = inputStream.readLine()) != null){ //! keep reading (Always remember String = readline)
                response.append(inputline);
            }inputStream.close();


            /* */
            JSONObject json = new JSONObject(response.toString());
            Double ExchangeRate = json.getJSONObject("info").getDouble("rate");

            System.out.println(json.getJSONObject("info"));
            System.out.println(ExchangeRate);
            System.out.println();
            System.out.println(df.format(määrä) +" "+ mistä + " = " + df.format(määrä/ExchangeRate) +" "+minne);
        }
        else {
            System.out.println("GET request failed");
        }

    }


    public void start(Stage arg0) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }
}