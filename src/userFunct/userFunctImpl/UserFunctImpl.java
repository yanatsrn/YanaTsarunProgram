package userFunct.userFunctImpl;

import entities.Person;
import exc.UserException;
import userFunct.UserFunct;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static util.UserFunctUtil.*;

public class UserFunctImpl implements UserFunct {

    @Override
    public boolean createRecord(ArrayList<Person> list, Person person, int id) throws UserException {
        boolean isAdd = true;
        try {
            person.setId(id);
            getName(person);
            getSurname(person);
            getEmail(list, person);
            String possibleValues = """
                    Возможные роли:
                    1 уровень: USER, CUSTOMER
                    2 уровень: ADMIN, PROVIDER
                    3 уровень: SUPER_ADMIN
                    """;
            System.out.println(possibleValues);
            getRole(person);
            possibleValues = """
                    Количество телефонов от 1 до 3
                    Телефон в виде +375331234567
                    Код оператора может быть 25, 29, 33, 44
                    """;
            System.out.println(possibleValues);
            getPhone(person);
        } catch (UserException e) {
            System.out.println("Ошибка");
            isAdd = false;
        }

        return isAdd;
    }

    @Override
    public void editRecord(ArrayList<Person> list) throws UserException {

        Scanner in = new Scanner(System.in);
        int id = 0;
        id = findEmail(list, id);
        if (id != 0) {
            String choice = " ";
            String menu = """
                Для изменения поля введите:
                1. Имя
                2. Фамилия
                3. Роль
                4. Телефон
                5. Выход
                """;
            while(!choice.equals("5")) {
                System.out.println(menu);
                System.out.print("Выбор: ");
                choice = in.next();
                switch (choice) {
                    case "1":
                        System.out.println("Введите имя: ");
                        list.get(id - 1).setName(in.next());
                        System.out.println("Изменения внесены");
                        break;
                    case "2":
                        System.out.println("Введите фамилию: ");
                        list.get(id - 1).setSurname(in.next());
                        System.out.println("Изменения внесены");
                        break;
                    case "3":
                        getRole(list.get(id - 1));
                        System.out.println("Изменения внесены");
                        break;
                    case "4":
                        getPhone(list.get(id - 1));
                        System.out.println("Изменения внесены");
                        break;
                    case "5":
                        break;

                }
            }
        }
        else {
            System.out.println("Такой почты нет. " +
                    "Проверьте корректность");
        }
    }

    @Override
    public boolean deleteRecord(ArrayList<Person> list) throws UserException {
        int personId = 0;
        list.remove(findEmail(list, personId)-1);
        System.out.println("Эта запись удалена");
        return false;
    }

    @Override
    public void showRecords(ArrayList<Person> list) throws UserException {
        for (Person personArrayList : list) {   //вывод всего списка
            System.out.println(personArrayList);
        }
    }

    @Override
    public void showPersonRecord(ArrayList<Person> list) throws UserException {
        int personId = 0;
        System.out.println("Запись пользователя\n" + list.get(findEmail(list, personId)-1));
    }

    @Override
    public boolean fileOutput(ArrayList<Person> list) throws UserException {
        boolean isAdded = true;
        try (FileWriter writer = new FileWriter("file.txt", false)) {
            for (Person personArrayList : list) {
                writer.write(personArrayList.getId());
                writer.write(" ");
                writer.write(personArrayList.getName());
                writer.write(" ");
                writer.write(personArrayList.getSurname());
                writer.write(" ");
                writer.write(personArrayList.getEmail());
                writer.write(" ");
                writer.write(String.valueOf(personArrayList.getRole()));
                writer.write(" ");
                writer.write(String.valueOf(personArrayList.getPhone()));
                writer.write("\n");
            }
        } catch (IOException e) {
            isAdded = false;
            System.out.println(e.getMessage());
        }
        return isAdded;
    }

}
