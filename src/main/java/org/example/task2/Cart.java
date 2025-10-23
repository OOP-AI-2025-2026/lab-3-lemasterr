package org.example.task2;

import java.util.Arrays;

public class Cart {

    private Item[] contents;
    private int index;

    public Cart(Item[] contents) {
        if (contents == null || contents.length == 0)
            throw new IllegalArgumentException("Масив товарів не може бути порожнім");
        this.contents = contents;
        this.index = 0;
    }

    public void add(Item item) {
        if (this.isCartFull()) {
            System.out.println("Кошик заповнений — не можна додати новий товар.");
            return;
        }
        this.contents[this.index] = item;
        this.index++;
    }

    public void removeById(long itemId) {
        if (this.index == 0) return;

        int foundItemIndex = this.findItemIndexById(itemId);
        if (foundItemIndex == -1) return;

        if (foundItemIndex == this.index - 1) {
            this.contents[this.index - 1] = null;
            this.index--;
            return;
        }

        this.shiftArray(foundItemIndex);
    }

    private int findItemIndexById(long id) {
        for (int i = 0; i < this.index; i++) {
            if (this.contents[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private void shiftArray(int itemIndex) {
        for (int i = itemIndex; i < this.index - 1; i++) {
            this.contents[i] = this.contents[i + 1];
        }
        this.contents[this.index - 1] = null;
        this.index--;
    }

    public boolean isCartFull() {
        return this.index == this.contents.length;
    }

    public int getSize() {
        return this.index;
    }

    public double getTotalPrice() {
        double total = 0;
        for (int i = 0; i < this.index; i++) {
            total += this.contents[i].getPrice();
        }
        return total;
    }

    // метод toString() для відображення стану кошика
    @Override
    public String toString() {
        return "Cart{" +
                "contents=" + Arrays.toString(Arrays.copyOf(this.contents, this.index)) +
                ", total=" + this.getTotalPrice() + " грн" +
                '}' + "\n";
    }
}
