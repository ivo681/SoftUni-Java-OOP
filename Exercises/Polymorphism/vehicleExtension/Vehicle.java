import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private int tankCapacity;

    protected Vehicle(Double fuelQuantity, Double fuelConsumption, int tankCapacity){
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public Double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected Double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected int getTankCapacity() {
        return this.tankCapacity;
    }

    private void setFuelQuantity(Double fuelQuantity) {
        if (fuelQuantity <= 0){
            System.out.println("Fuel must be positive number");
        } else {
            this.fuelQuantity = fuelQuantity;
        }
    }

    protected void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }



    public void drive(double distance){
        if (getFuelQuantity() > distance*getFuelConsumption()){
            Double remainingFuel = getFuelQuantity() - (distance*getFuelConsumption());
            setFuelQuantity(remainingFuel);
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), df.format(distance));
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }

    public void refuel(double liters){
        if (liters > 0) {
            if (getTankCapacity() >= this.fuelQuantity + liters) {
                this.fuelQuantity += liters;
            } else {
                System.out.println("Cannot fit fuel in tank");
            }
        } else {
            System.out.println("Fuel must be a positive number");
        }
    }
}
