package org.example.task2;

public class Box {
    private double length; // довжина
    private double width;  // ширина
    private double height; // висота

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) throw new IllegalArgumentException("Довжина має бути > 0");
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) throw new IllegalArgumentException("Ширина має бути > 0");
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) throw new IllegalArgumentException("Висота має бути > 0");
        this.height = height;
    }

    // Повна площа поверхні: 2(lw + lh + wh)
    public double surfaceArea() {
        return 2.0 * (length * width + length * height + width * height);
    }

    // Площа бічної поверхні: 2h(l + w)
    public double lateralSurfaceArea() {
        return 2.0 * height * (length + width);
    }

    // Об'єм: l * w * h *
    public double volume() {
        return length * width * height;
    }
}
