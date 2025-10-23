package org.example.task2;

public class IntStack {

    private int[] data;      // масив для зберігання елементів стеку
    private int size;        // кількість елементів у стеку
    private static final int INITIAL_CAPACITY = 10; // початковий розмір масиву

    public IntStack() {
        this.data = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void push(int value) {
        if (this.size == this.data.length) {
            this.expandCapacity();
        }
        this.data[this.size] = value;
        this.size++;
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Стек порожній — неможливо виконати pop()");
        }
        int value = this.data[this.size - 1];
        this.size--;
        return value;
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Стек порожній — неможливо виконати peek()");
        }
        return this.data[this.size - 1];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.size = 0;
    }

    //Збільшує розмір масиву у 2 рази, коли місця не вистачає.

    private void expandCapacity() {
        int newCapacity = this.data.length * 2;
        int[] newData = new int[newCapacity];
        System.arraycopy(this.data, 0, newData, 0, this.size);
        this.data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("IntStack[ ");
        for (int i = 0; i < this.size; i++) {
            sb.append(this.data[i]);
            if (i < this.size - 1) sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
