package com.coforge.day3;

public class Mobile {

    private String brand;
    private String model;
    private int ram;
    private double price;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public double getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Brand = " + brand +
                "\nModel = " + model +
                "\nRAM = " + ram + " GB" +
                "\nPrice = " + price;
    }

    public static void main(String[] args) {

        Mobile m = new Mobile();

        m.setBrand("Samsung");
        m.setModel("Galaxy S24");
        m.setRam(12);
        m.setPrice(79999);

        System.out.println(m);
    }
}
