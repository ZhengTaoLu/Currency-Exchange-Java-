import java.io.IOException;
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
            
            mistä = Rahaa.get(Integer.valueOf(lukija.nextLine()));

            System.out.println("Currency converting to? \n");
            System.out.println("1:EUR \t 2:USD \t 3:CNY \t " +
                                "4:JPY \t 5:TWD \n");
            
            minne = Rahaa.get(Integer.valueOf(lukija.nextLine()));

            System.out.println("Amount? \n");
            määrä = Double.valueOf(lukija.nextLine());
        }


    }
    private static void Valuutta(String mistä, String minne, Double määrä) throws IOException{
        
        String url_str = "https://api.exchangerate.host/convert?from=" + mistä +"&to=" + minne;

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        
        if(request.getResponseCode() == HttpURLConnection.HTTP_OK){
            
        }
    }
}
