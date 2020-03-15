
public class Car {
    private String brand;
    private String model;
    private String color;

    public Car() {
        new Car("Tesla", "Model S", "Reed");
    }
    public Car(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

}

public static void main(String[] args) {
    Car samochodzik = new SuperCar("Lamborghini", "Aventador", "Black");
}

