public class Bus extends Vehicle{
    private Double defaultConsumption;
    Bus(Double fuelQuantity, Double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.defaultConsumption = fuelConsumption;
    }

    @Override
    public void drive(double distance) {
        super.setFuelConsumption(this.defaultConsumption + 1.4);
        super.drive(distance);
    }

    public void driveEmpty(double distance){
        super.setFuelConsumption(this.defaultConsumption);
        super.drive(distance);
    }
}
