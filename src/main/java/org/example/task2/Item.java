package org.example.task2;

public class Item {
    private long id;
    private String name;
    private double price;

    public Item(long id, String name, double price) {
        // використання this і перевірки даних
        if (id <= 0) {
            throw new IllegalArgumentException("ID має бути більше 0");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Назва не може бути порожньою");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Ціна не може бути від'ємною");
        }

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", price=" + this.price +
                " грн}";
    }
}
