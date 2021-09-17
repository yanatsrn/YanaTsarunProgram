package userFunct;

import entities.Person;
import exc.UserException;
import java.util.ArrayList;

public interface UserFunct {
    boolean createRecord(ArrayList<Person> list, Person person, int n) throws UserException;
    void editRecord(ArrayList<Person> list) throws UserException;
    boolean deleteRecord(ArrayList<Person> list) throws UserException;
    void showRecords(ArrayList<Person> list) throws UserException;
    void showPersonRecord(ArrayList<Person> list) throws UserException;
    boolean fileOutput(ArrayList<Person> list) throws UserException;
}
