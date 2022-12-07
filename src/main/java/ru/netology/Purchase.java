package ru.netology;

/**
 * Исправлено нарушение принципа единственной ответственности, теперь
 * класс Purchase отвечает только за объект - покупка(purchase).
 */
public class Purchase {
    protected String title;
    protected int count;

    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }
}


