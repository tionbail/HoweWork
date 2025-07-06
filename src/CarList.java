public interface CarList {
    Car get(int index);
    void add(Car car);
    void addAll(CarList newCarList);
    boolean removeIndex(int index);
    int size();
}
