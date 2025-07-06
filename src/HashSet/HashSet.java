package HashSet;

public class HashSet<E> {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;
    private Entry<E>[] array = (Entry<E>[]) new Entry[INITIAL_CAPACITY];

    public boolean add(E key) {
        if (key == null) {
            throw new NullPointerException("Key can't be null");
        }

        if (size >= array.length * LOAD_FACTOR) {
            resizeArray();
        }

        int position = getIndex(key);

        if (array[position] == null) {
            Entry entry = new Entry<>(key, null);
            array[position] = entry;
            size++;
            return true;
        } else {
            Entry<E> existedElement = array[position];
            while (true) {
                if (existedElement.value.equals(key)) {
                    return false;
                } else if (existedElement.next == null) {
                    existedElement.next = new Entry<>(key, null);
                    size++;
                    return true;
                } else {
                    existedElement = existedElement.next;
                }
            }
        }
    }

    public boolean remove(E key) {
        if (key == null) {
            throw new NullPointerException("Key can't be null");
        }
        //Номер позиции массиве
        int position = getIndex(key);
        //ЕСли ничего в позициии не лежит - выходим
        if (array[position] == null) {
           return false;
        }
        //Иначе сохраняем значения последнего и предпосл.элемента
        Entry<E> secondLast = array[position];
        Entry<E> last = secondLast.next;
        //Чтобы не произошло удаление ячейки, кладем значение последнего элемента
        if (secondLast.value.equals(key)) {
            array[position] = last;
            size--;
            return true;
        }
        //Если значение не равны, нужно повторять процесс со следующими элементами
        while (last !=null) {
            if (last.value.equals(key)) {
                secondLast.next = last.next;
                size--;
                return true;
            } else {
                secondLast = last;
                last = last.next;
            }
        }
        return false;
    }

    private void resizeArray () {
        Entry<E>[] oldArray = array;
        array = new Entry[oldArray.length *2];
        size = 0;
        for (Entry<E> entry : oldArray) {
            Entry<E> existedElement = entry;
            while (existedElement !=null) {
                add((E)existedElement.value);
                existedElement = existedElement.next;
            }
        }
    }

    public int size() {
        return size;
    }

    private static class Entry<E> {
        private E value;
        private Entry<E> next;

        public Entry(E value, Entry<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int getIndex(E key) {
        return Math.abs(key.hashCode() % array.length);
    }


}
