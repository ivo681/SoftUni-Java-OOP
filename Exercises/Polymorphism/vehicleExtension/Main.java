import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] carTokens = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]), Integer.parseInt(carTokens[3]));
        String [] truckTokens = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]), Integer.parseInt(truckTokens[3]));
        String [] busTokens = scanner.nextLine().split("\\s+");
        Vehicle bus = new Bus(Double.parseDouble(busTokens[1]), Double.parseDouble(busTokens[2]), Integer.parseInt(busTokens[3]));
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String [] commandTokens = scanner.nextLine().split("\\s+");
            switch (commandTokens[0]){
                case "Drive":
                    if (commandTokens[1].equals("Car")){
                        car.drive(Double.parseDouble(commandTokens[2]));
                    } else if (commandTokens[1].equals("Truck")){
                        truck.drive(Double.parseDouble(commandTokens[2]));
                    } else if (commandTokens[1].equals("Bus")){
                        ((Bus)bus).drive(Double.parseDouble(commandTokens[2]));
                    }
                    break;
                case "Refuel":
                    if (commandTokens[1].equals("Car")){
                        car.refuel(Double.parseDouble(commandTokens[2]));
                    } else if (commandTokens[1].equals("Truck")){
                        truck.refuel(Double.parseDouble(commandTokens[2]));
                    } else if (commandTokens[1].equals("Bus")){
                        bus.refuel(Double.parseDouble(commandTokens[2]));
                    }
                    break;
                case "DriveEmpty":
                    ((Bus)bus).driveEmpty(Double.parseDouble(commandTokens[2]));
                    break;
            }
        }

        System.out.printf("Car: %.2f%nTruck: %.2f%nBus: %.2f%n", car.getFuelQuantity(), truck.getFuelQuantity(), bus.getFuelQuantity());
    }
}
