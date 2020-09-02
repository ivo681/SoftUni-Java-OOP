public class Car extends Vehicle{

    Car(Double fuelQuantity, Double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption+0.9, tankCapacity);
    }
}
