package com.company;

public class Main {
    public static void main(String[] args) throws Exception {
        CarsManager carsManager = new CarsManager();
        int action = -1;
        boolean isRun = true;

        while (isRun) {

            carsManager.printCars();

            ConsoleHelper.PrintMessage("Меню:");
            ConsoleHelper.PrintMessage("1. Добавить машину в конец списка");
            ConsoleHelper.PrintMessage("2. Удалить машину по ИД");
            ConsoleHelper.PrintMessage("3. Изменить мощность машины по ИД");
            ConsoleHelper.PrintMessage("4. Изменить скорость машины по ИД");
            ConsoleHelper.PrintMessage("5. Изменить цвет машины по ИД");
            ConsoleHelper.PrintMessage("0. Выход");

            action = ConsoleHelper.InputInt("Введите номер пункта меню: ", 0, 5);

            switch (action) {
                case 1: {
                    int enginePower = ConsoleHelper.InputInt("Введите мощность двигателя(л/с): ");
                    double maxSpeed = ConsoleHelper.InputDouble("Введите максимальную скорость (км/ч): ");
                    double weight = ConsoleHelper.InputDouble("Введите вес машины (тонны): ");
                    String brandName = ConsoleHelper.InputString("Введите марку машины: ");
                    String model = ConsoleHelper.InputString("Введите модель машины: ");
                    int colorIndex = ConsoleHelper.InputInt("Введите индекс цвета(0-красный, 1-зелёный, 2-голубой, 3-чёрный, 4-жёлтый): ", 0, 4);
                    Car.Color color = Car.Color.values()[colorIndex];

                    carsManager.addCar(enginePower, maxSpeed, weight, brandName, model, color);
                }
                break;

                case 2: {
                    try {
                        int id = ConsoleHelper.InputInt("Введите ИД машины для удаления: ");
                        carsManager.deleteCar(id);
                    } catch (Exception e) {
                        ConsoleHelper.PrintMessage(e.getMessage());
                    }

                }
                break;

                case 3: {
                    try {
                        int id = ConsoleHelper.InputInt("Введите ИД машины для изменения мощности: ");
                        int enginePower = ConsoleHelper.InputInt("Введите мощность двигателя(л/с): ");
                        carsManager.getByIdCar(id).setEnginePower(enginePower);
                    } catch (Exception e) {
                        ConsoleHelper.PrintMessage(e.getMessage());
                    }
                }
                break;

                case 0: {
                    isRun = false;
                }
                break;
            }
        }
    }
}