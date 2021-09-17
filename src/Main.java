import entities.Person;
import entities.RoleType;
import exc.UserException;
import userFunct.userFunctImpl.UserFunctImpl;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void menu() throws UserException {

        ArrayList<Person> list = new ArrayList<>();
        int idForUsers = 1;
        ArrayList<RoleType> roles = new ArrayList<>();
        roles.add(RoleType.SUPER_ADMIN);
        Person person1 = new Person(idForUsers, "Yana", "Tsarun", roles, "yana210901@gmail.com", null);
        list.add(person1);
        String choice = " ";
        UserFunctImpl user = new UserFunctImpl();
        while (!choice.equals("6")) {
            String menu = """
                    Введите цифру для работы
                    1. Создать запись
                    2. Изменить запись
                    3. Удалить запись
                    4. Посмотреть все записи
                    5. Посмотреть свою запись
                    6. Выход
                    """;
            System.out.println(menu);
            Scanner in = new Scanner(System.in);
            System.out.print("Выбор: ");
            choice = in.next();
            switch (choice) {
                case "1":
                    Person person = new Person();
                    idForUsers++;
                    user.createRecord(list, person, idForUsers);
                    list.add(person);
                    break;
                case "2":
                    user.editRecord(list);
                    user.fileOutput(list);
                    break;
                case "3":
                    user.deleteRecord(list);
                    user.fileOutput(list);
                    break;
                case "4":
                    user.showRecords(list);
                    break;
                case "5":
                    user.showPersonRecord(list);
                    break;
                case "6":
                    user.fileOutput(list);
                    break;
                default:
                    System.out.println("Нет такого номера");
                    break;
            }
        }
    }

    public static void main(String[] args) throws UserException {
        menu();
    }
}
