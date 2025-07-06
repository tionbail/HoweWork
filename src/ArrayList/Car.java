package ArrayList;

public class Car {
    public String name;
    public int number;

    public Car(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}
