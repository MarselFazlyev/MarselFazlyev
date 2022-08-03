package marsel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws AccessDeniedException,UserNotFoundException {
        Scanner scanner = new Scanner(System.in);
        User[] users = {
                new User("Татьяна Фазлыева", 3457, 35, "tatiana@mail.ru"),
                new User("Милана Фазлыева", 1909, 2, "milashka@yandex.ru"),
                new User("Вера Чиндякова", 1965, 56, "tesha@gmail.com"),
        };
        System.out.println(" Введите логин(имя/фамилия)");
        String login = scanner.nextLine();
        System.out.println(" Введите пароль ");
        String stringPassword = scanner.nextLine();
        int password = Integer.parseInt(stringPassword);
        if (!checkLogin(login, password, users)) {
            throw new UserNotFoundException(" Неверный ввод логина или пароля!");
        }
        if (!checkAge(login,users)) {
            throw new AccessDeniedException(" Вход несовершеннолетним запрещен!");
        }
        System.out.println("Доступ предоставлен!");


    }

    public static boolean checkLogin(String login, int password, User[] users) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword() == password) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkAge( String login, User[] users) {
      for (User user : users) {
          if (user.getLogin().equals(login)) {
              System.out.println(user.getAge());
              return user.getAge()>=18;
          }
      }
      System.out.println("Подбзователь не идентифицирован.");
      return false;
    }
}
