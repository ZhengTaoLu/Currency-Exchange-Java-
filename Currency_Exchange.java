import java.util.HashMap;
import java.util.Scanner;

public class Currency_Exchange {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, String> Rahaa = new HashMap<>();
        Scanner lukija = new Scanner(System.in);

        Rahaa.put(1, "EUR");
        Rahaa.put(2, "USD");
        Rahaa.put(3, "CNY");
        Rahaa.put(4, "JPY");
        Rahaa.put(5, "TWD");

        String fromCode, toCode;
        double määrä;

        System.out.println("Currency converting from?" + "\n");
        System.out.println("1:EUR \t 2:USD \t 3:CNY \t " +
                            "4:JPY \t 5:TWD" + "\n");
    }
}
