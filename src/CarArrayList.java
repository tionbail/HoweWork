public class CarArrayList implements CarList{

    private Car[] array = new Car[10];
    private int size = 0;

    @Override
    public Car get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public void add(Car car) {
        if (size >= array.length) {
            Car[] newArray = new Car[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = car;
        size++;
    }

    @Override
    public void addAll(CarList newCarList) {
        for (int i = 0; i < newCarList.size(); i++ ) {
            this.add(newCarList.get(i));
        }
    }

    @Override
    public boolean removeIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size -1; i++) {
            array[i] = array [i +1];
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }
}
