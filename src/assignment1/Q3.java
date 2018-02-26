package assignment1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        /*
            For this question we will assume that the input looks like
            n - Followed by n lines of:
            Item Price
            m - Followed by M lines of:
            Quantity Item
            Assuming that the data is coming from stdin
         */
        Scanner input = new Scanner(System.in);
        Map<String, Double> prices = new HashMap<>();

        double total = 0;

        int n = Integer.parseInt(input.nextLine());
        while(n-->0) {
            String item = input.next();
            double price =  Double.parseDouble(input.nextLine());
            prices.put(item, price);
        }
        int m = Integer.parseInt(input.nextLine());
        while(m-->0) {
            int quantity = Integer.parseInt(input.next());
            String item = input.nextLine().trim();
            if(prices.containsKey(item)) {
                total += prices.get(item) * quantity;
            }else {
                throw new RuntimeException("Undefined grocery item");
            }
        }
        System.out.println(String.format("The total of the shopping list is: $%.2f",  total));
        System.exit(0);
    }
}
