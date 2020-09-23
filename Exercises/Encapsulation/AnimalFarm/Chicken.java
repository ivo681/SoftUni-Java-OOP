package AnimalFarm;

public class Chicken {
    private String name;
    private int age;


    public Chicken(String name, int age){
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.equals(" ")){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double productPerDay(){
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        if (this.getAge() < 6){
            return 2;
        } else if (this.getAge() < 12){
            return 1;
        } else {
            return 0.75;
        }
    }

    @Override
    public String toString() {
        return String.format("Chichken %s (age %d) can produce %.2f eggs per day.", this.getName(), this.getAge(), this.productPerDay());
    }
}
