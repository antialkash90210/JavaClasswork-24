package com.company;

public class CarsManager {
    private int id;
    private Car[] cars;

    public CarsManager() {
        id = 0;
        cars = new Car[0];
    }

    //region Util Methods

    private int getIndexByIdCar(int id) {

        int index = -1;
        int middle = cars.length / 2;
        int first = 0;
        int last = cars.length - 1;

        if (id < cars[first].getId() || id > cars[last].getId()) {
            return -1;
        }

        do {
            if (id < cars[middle].getId()) {
                last = middle - 1;
                middle = (first + last) / 2;
            } else if (id > cars[middle].getId()) {
                first = middle + 1;
                middle = (first + last) / 2;

            } else {
                index = middle;
                break;
            }
        }
        while (first <= last);

        return index;
    }

    //endregion

    //region Main Methods

    public void addCar(int enginePower, double maxSpeed, double weight, String brandName, String model, Car.Color color) {
        id++;
        Car car = new Car(id, enginePower, maxSpeed, weight, brandName, model, color);

        Car[] tempCars = new Car[cars.length + 1];

        for (int i = 0; i < cars.length; i++) {
            tempCars[i] = cars[i];
        }

        tempCars[tempCars.length - 1] = car;

        cars = tempCars;
    }

    public void deleteCar(int id) throws Exception {
        int index = getIndexByIdCar(id);

        if (index == -1) {
            throw new Exception("car with id = " + id + " not found");
        }

        Car[] tempCars = new Car[cars.length - 1];

        for (int i = 0; i < index; i++) {
            tempCars[i] = cars[i];
        }

        for (int i = index + 1; i < cars.length; i++) {
            tempCars[i - 1] = cars[i];
        }

        cars = tempCars;
    }

    public Car getByIdCar(int id) throws Exception {
        int index = getIndexByIdCar(id);

        if (index == -1) {
            throw new Exception("car with id = " + id + " not found");
        }

        return cars[index];
    }

    public void printCars() {
        if (cars.length == 0) {
            System.out.println("Список пуст");
            System.out.println("==========");
        } else {
            for (int i = 0; i < cars.length; i++) {
                System.out.println(cars[i].getInString());
                System.out.println("==========");
            }
        }
    }

    //endregion
}