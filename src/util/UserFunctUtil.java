package util;

import entities.Person;
import entities.RoleType;
import validator.Validator;

import java.util.ArrayList;
import java.util.Scanner;

public class UserFunctUtil {

    private static final int COUNT_OF_PHONES = 3;
    private static final int COUNT_OF_ROLES = 2;

    public static void getName(Person person) {

        Scanner in = new Scanner(System.in);
        boolean isCorrectName = false;
        String name;
        while (!isCorrectName) {
            System.out.print("Введите имя: ");
            name = in.next();
            if (!Validator.isValidString(name)) {
                System.out.println("Некорректный ввод имени." +
                        " Повторите попытку");
            }
            else {
                person.setName(name);
                isCorrectName = true;
            }
        }
    }

    public static void getSurname(Person person) {
        Scanner in = new Scanner(System.in);
        boolean isCorrectSurname = false;
        String surname;
        while (!isCorrectSurname) {
            System.out.print("Введите фамилию: ");
            surname = in.next();
            if (!Validator.isValidString(surname)) {
                System.out.println("Некорректный ввод фамилии." +
                        " Повторите попытку");
            }
            else {
                person.setSurname(surname);
                isCorrectSurname = true;
            }
        }
    }

    public static void getEmail(ArrayList<Person> list, Person person) {
        Scanner in = new Scanner(System.in);
        boolean isCorrectEmail = false;
        String mail;
        while (!isCorrectEmail) {
            System.out.print("Введите почту: ");
            mail = in.next();
            if (!Validator.isValidEmail(mail)) {
                System.out.println("Некорректный ввод почты." +
                        " Повторите попытку");
            }
            else if (list.size() > 1 && !(isUniqueEmail(list, mail))) {
                System.out.println("Такая почта уже зарегистрирована." +
                        " Введите другую");
            }
            else {
                person.setEmail(mail);
                isCorrectEmail = true;
            }
        }
    }

    public static void getRole(Person person) {
        ArrayList<RoleType> roles = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        RoleType parameter;
        for (int i = 0; i < COUNT_OF_ROLES; i++) {
            if (i > 0) {
                boolean isCorrectRole = false;
                while (!isCorrectRole) {
                    System.out.print("Введите роль: ");
                    String role = in.next();
                    if (role.equals("USER")  || role.equals("ADMIN") || role.equals("PROVIDER") || role.equals("CUSTOMER") || role.equals("SUPER_ADMIN")) {
                        parameter = RoleType.valueOf(role);
                        if (parameter.equals(RoleType.SUPER_ADMIN)) {
                            System.out.println("При других ролях нельзя стать SUPER_ADMIN");
                        }
                        else if (parameter.equals(roles.get(0))) {
                            System.out.println("Такая роль уже есть. Повторите ввод");
                        }
                        else if (roles.get(0).equals(RoleType.SUPER_ADMIN)) {
                            System.out.println("Вы уже SUPER_ADMIN, другие роли нельзя выбрать");
                            i = 2;
                            break;
                        }
                        else if (roles.get(0).equals(RoleType.USER) && parameter.equals(RoleType.CUSTOMER)
                                || roles.get(0).equals(RoleType.CUSTOMER) && parameter.equals(RoleType.USER)) {
                            System.out.println("2 роли с одного уровня нелья");
                        }
                        else if (roles.get(0).equals(RoleType.PROVIDER) && parameter.equals(RoleType.ADMIN)
                                || roles.get(0).equals(RoleType.ADMIN) && parameter.equals(RoleType.PROVIDER)) {
                            System.out.println("2 роли с одного уровня нелья");
                        }
                        else {
                            roles.add((parameter));
                            isCorrectRole = true;
                        }
                    }
                    else {
                        System.out.println("Некорректно введена роль");
                    }
                }
            } else {
                System.out.print("Введите роль: ");
                String role = in.next();
                if (role.equals("USER") || role.equals("ADMIN") || role.equals("PROVIDER") || role.equals("CUSTOMER") || role.equals("SUPER_ADMIN")) {
                    parameter = RoleType.valueOf(role);
                    roles.add((parameter));
                }
                else {
                    System.out.println("Некорректно введена роль");
                    i--;
                }
            }
            if (i == 0) {
                String choice;
                System.out.println("Хотите ввести еще одну роль?");
                System.out.println("Ответ да/нет");
                choice = in.next();
                if (!choice.equals("да")) {
                    i = 2;
                }
            }
        }
        person.setRole(roles);
    }

    public static void getPhone(Person person) {
        ArrayList<String> phones = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String nn;
        for (int i = 1; i <= COUNT_OF_PHONES; i++) {
            boolean isCorrectPhone = false;
            while (!isCorrectPhone) {
                System.out.print("Введите телефон " + i + ": ");
                nn = in.next();
                if (!Validator.isValidPhone(nn)) {
                    System.out.println("Некорректный ввод телефона");
                }
                else {
                    isCorrectPhone = true;
                    phones.add(nn);
                }
            }
            String choice;
            System.out.println("Хотите ввести еще один телефон?");
            System.out.println("Ответ да/нет");
            choice = in.next();
            if (!choice.equals("да")) {
                i = 4;
            }
        }
        person.setPhone(phones);
    }

    public static boolean isUniqueEmail(ArrayList<Person> arrayList, String mail) {
        boolean isUnique = true;
        for (Person personArrayList : arrayList) {   //поиск введенной почты
            if (personArrayList.getEmail().equals(mail)) {
                isUnique = false;
            }
        }
        return isUnique;
    }

    public static int findEmail(ArrayList<Person> arrayList, int id) {
        Scanner in = new Scanner(System.in);
        String mail = " ";
        boolean isCorrectEmail = false;
        while (!isCorrectEmail) {
            System.out.println("Введите почту искомого пользователя");
            mail = in.next();
            if (!Validator.isValidEmail(mail)) {
                System.out.println("Некорректный ввод почты. Повторите попытку");
            }
            else {
                isCorrectEmail = true;
            }
        }
        for (Person personArrayList : arrayList) {   //поиск введенной почты
            if (personArrayList.getEmail().equals(mail)) {
                id = personArrayList.getId();
            }
        }
        return id;
    }
}
