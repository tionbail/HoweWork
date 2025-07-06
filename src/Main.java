//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CarList carList = new CarArrayList();

        System.out.println(carList.size());
        Car Lada = new Car("lada", 001);
        Car Mazda = new Car("Mazda", 002);
        //Добввляю машины
        carList.add(Lada);
        carList.add(Mazda);
        //Размер после добавления
        System.out.println(carList.size());
        //Получение элементов по индексу
        System.out.println(carList.get(0));
        System.out.println(carList.get(1));
        //Удаление по индексу
        carList.removeIndex(0);
        System.out.println(carList.get(0));
        System.out.println(carList.size());
        //Добавления списка в список
        CarList newCarList = new CarArrayList();
        newCarList.add(new Car("BMW", 010));
        newCarList.add(new Car("Opel", 011));
        newCarList.add(new Car("SEAT", 012));
        carList.addAll(newCarList);
        System.out.println(carList.get(0));
    }
}