package org.example.task2;

public class Main {
    public static void main(String[] args) {

        Box box = new Box(2.5, 3.0, 4.0);
        System.out.println("=== Box ===");
        System.out.printf("Площа поверхні: %.2f%n", box.surfaceArea());
        System.out.printf("Площа бічної поверхні: %.2f%n", box.lateralSurfaceArea());
        System.out.printf("Об'єм: %.2f%n", box.volume());

        Cart cart = new Cart(new Item[10]);
        cart.add(new Item(1, "Samsung Galaxy S23", 27999));
        cart.add(new Item(2, "Lenovo IdeaPad 3", 19499));
        cart.add(new Item(3, "LG 55\" 4K Smart TV", 15999));
        cart.add(new Item(4, "Bosch Serie 6 Пральна машина", 14799));
        cart.add(new Item(5, "Samsung RB34 Холодильник", 22399));
        cart.add(new Item(6, "De'Longhi Magnifica S Кавоварка", 10599));
        cart.add(new Item(7, "Gorenje Електрична плита", 9999));
        cart.add(new Item(8, "Dyson V11 Пилосос", 16499));
        cart.add(new Item(9, "Samsung ME83K Мікрохвильова піч", 3199));
        cart.add(new Item(10, "Philips DryCare Фен", 1499));

        System.out.println(cart);

        cart.removeById(9);

        System.out.println(cart);

        Order order = new Order(1L, "John");
        String bill = order.formOrderBill(cart);
        System.out.println(bill);

        IntStack st = new IntStack();
        st.push(10); st.push(20); st.push(30);
        System.out.println(st);
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.size());
        st.clear();
        System.out.println(st.isEmpty());
    }
}
