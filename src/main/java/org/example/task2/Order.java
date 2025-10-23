package org.example.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {

    private long id;
    private String customer;

    public Order(long id, String customer) {
        if (id <= 0)
            throw new IllegalArgumentException("ID замовлення має бути більше 0");
        if (customer == null || customer.isBlank())
            throw new IllegalArgumentException("Ім’я клієнта не може бути порожнім");

        this.id = id;
        this.customer = customer;
    }

    public long getId() {
        return this.id;
    }

    public String getCustomer() {
        return this.customer;
    }

    public String formOrderBill(Cart cart) {
        StringBuilder builder = new StringBuilder();

        builder.append("===== РАХУНОК =====\n");
        builder.append("Номер замовлення: ").append(this.id).append("\n");
        builder.append("Клієнт: ").append(this.customer).append("\n");
        builder.append("Дата: ").append(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))).append("\n");
        builder.append("--------------------\n");

        double totalSum = 0.0;

        // отримаємо список товарів через гетери (без прямого доступу до полів)
        for (int i = 0; i < cart.getSize(); i++) {
            Item item = cart.getItemAt(i); // без доступу до масиву
            builder.append(String.format("ID: %d | %s | %.2f грн%n",
                    item.getId(), item.getName(), item.getPrice()));
            totalSum += item.getPrice();
        }

        builder.append("--------------------\n");
        builder.append(String.format("Загальна сума: %.2f грн%n", totalSum));
        builder.append("====================\n");

        return builder.toString();
    }
}
