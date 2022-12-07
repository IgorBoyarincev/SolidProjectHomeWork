package ru.netology;

import java.util.Map;

/**
 * Нарушенный принцип единственной ответственности, исправлен созданием
 * класса Basket, который и будет отвечать за объект корзина(basket).
 */

public class Basket {
    protected Map<String, Integer> prices;
    /**
     * Исправлено нарушение правила Magic: неиспользовать числа напрямую в коде.
     * Инициализация перенесена в конструктор:this.purchases=new Purchase[prices.size()]
     */
    protected Purchase[] purchases;

    public Basket(Map<String, Integer> prices) {
        this.prices = prices;
        this.purchases = new Purchase[prices.size()];
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public long sum() {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            Purchase purchase = purchases[i];
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
            sum += purchase.count * prices.get(purchase.title);
        }
        return sum;
    }
}
