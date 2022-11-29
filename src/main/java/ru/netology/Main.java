package ru.netology;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> products = new HashMap<>();
        products.put("hleb", 56);
        products.put("maslo", 153);
        products.put("kolbasa", 211);
        products.put("pirojok", 45);
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
        System.out.println("Введите два слова: название товара и количество. Или end: ");
        Scanner scanner = new Scanner(System.in);
        Basket basket = new Basket(products);
        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);
            basket.addPurchase(product, count);
        }
        long sum = basket.sum();
        System.out.println("ИТОГО: " + sum);
    }
}


