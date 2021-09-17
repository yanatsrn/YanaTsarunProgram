package entities;

import java.util.ArrayList;
import java.util.Objects;

public class Person {

    private int id;
    private String name;
    private String surname;
    private ArrayList<RoleType> role;
    private String email;
    private ArrayList<String> phone;

    public Person(int id, String name, String surname, String email, ArrayList<String> phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public Person(int id, String name, String surname, ArrayList<RoleType> role, String email, ArrayList<String> phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
        this.phone = phone;
    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<RoleType> getRole() {
        return role;
    }

    public void setRole(ArrayList<RoleType> role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getPhone() {
        return phone;
    }

    public void setPhone(ArrayList<String> phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(role, person.role) && Objects.equals(email, person.email) && Objects.equals(phone, person.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, role, email, phone);
    }

    @Override
    public String toString() {
        return  "Id: " + id + '\n' +
                "Имя: " + name + '\n' +
                "Фамилия: " + surname + '\n' +
                "Роли: " + role + '\n' +
                "Почта: "  + email + '\n' +
                "Телефоны: " + phone + '\n';
    }
}
