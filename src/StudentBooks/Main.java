package StudentBooks;

import java.time.Year;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Преступление и наказание", 1869, 432);
        Book book2 = new Book("Война и Мир", 1869, 1225);
        Book book3 = new Book("Сто лет одиночества", 1967, 422);
        Book book4 = new Book("1984", 1949, 328);
        Book book5 = new Book("Мастер и Маргарита", 1967, 450);
        Book book6 = new Book("Собачье сердце", 1968, 80);
        Book book7 = new Book("Игра престолов", 1996, 700);

        List<Student> students = Arrays.asList(new Student("Vova", Arrays.asList(book1,book2,book4,book6,book3)),
                new Student("Dima", Arrays.asList(book2, book3, book6, book7, book1)),
                new Student("Stepa", Arrays.asList(book3, book4, book5, book1, book2)),
                new Student("Petya", Arrays.asList(book1, book5, book6, book7, book3))
        );

        students.stream()
                .peek(student -> System.out.println(student.toString()))
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparing(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .findFirst()
                .ifPresentOrElse(year -> System.out.println("Год выпуска книги: " + year),
                        () -> System.out.println("Такая книга отсутствует")
                );


    }
}
