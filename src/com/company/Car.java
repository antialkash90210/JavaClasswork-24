package com.company;

public class Car {
    //region Enum Color

    public enum Color {
        red("красный"),
        green("зелёный"),
        blue("голубой"),
        black("чёрный"),
        yellow("жёлтый");

        private final String value;

        Color(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    //endregion

    //region Variables

    private int id;
    private int enginePower;
    private double maxSpeed;
    private double weight;
    private String brandName;
    private String model;
    private Color color;

    //endregion

    //region Constructors

    public Car() {
        id = 0;
        enginePower = 50;
        maxSpeed = 130;
        weight = 0.57;
        brandName = "Ford";
        model = "Model T";
        color = Color.black;
    }

    public Car(int id, int enginePower, double maxSpeed, double weight, String brandName, String model, Color color) {
        this.id = id;
        this.enginePower = enginePower;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.brandName = brandName;
        this.model = model;
        this.color = color;
    }

    public Car(int id, Car car) {
        this.id = id;
        enginePower = car.enginePower;
        maxSpeed = car.maxSpeed;
        weight = car.weight;
        brandName = car.brandName;
        model = car.model;
        color = car.color;
    }

    //endregion

    //region Setters

    public void setEnginePower(int enginePower) throws Exception {
        if (enginePower <= 0 || enginePower > 500) {
            throw new Exception("engine power must be grater than 0 and less then 501");
        }
        this.enginePower = enginePower;
    }

    public void setMaxSpeed(double maxSpeed) throws Exception {
        if (maxSpeed <= 0 || maxSpeed > 750) {
            throw new Exception("max speed must be grater than 0 and less then 401");
        }
        this.maxSpeed = maxSpeed;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //endregion

    //region Getters

    public int getEnginePower() {
        return enginePower;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public Color getColor() {
        return color;
    }

    public int getId() {
        return id;
    }

    //endregion

    public String getInString() {
        String output = "";

        output += "ИД: " + id + "\n";
        output += "двигатель: " + enginePower + "(лс)\n";
        output += "макс скорость: " + maxSpeed + "(км/ч)\n";
        output += "вес: " + weight + "(тонн)\n";
        output += "марка: " + brandName + "\n";
        output += "модель: " + model + "\n";
        output += "цвет: " + color.getValue();

        return output;
    }

}