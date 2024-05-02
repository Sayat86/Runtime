package jpa;

import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Введите вид действия");
            System.out.println("1 - Создать автора");
            System.out.println("2 - Создать книгу");
            System.out.println("3 - Удалить книгу");
            System.out.println("4 - Найти книгу по автору");
            System.out.println("5 - Выйти из программы");

            int num = Integer.parseInt(scanner.nextLine());
            if (num == 5) {
                System.out.println("Вы вышли из программы");
                break;
            }

            switch (num) {
                case 1:
                    CreateAuthor.createAuthor();
                    break;

                case 2:
                    CreateBook.createBook();
                    break;

                case 3:
                    DeleteBook.deleteBook();
                    break;

                case 4:
                    Select.selectBookName();
                    break;

                default:
                    System.out.println("Вариант не существует");
                    break;
            }
        }
    }
}
