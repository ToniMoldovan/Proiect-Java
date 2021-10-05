package Project;
import java.util.Objects;
import java.util.Scanner;

public class People {
    static int personCounter = 0;
    static int personId = 100;
    private String _adminPassword = "pufuleti";

    Library library = new Library();

    static class Person {
        private boolean _isAdmin;
        private boolean _isBanned;
        private int _persId = personId;

        String personName;

        Person next;

        //Constructor
        public Person(String personName, boolean _isAdmin) {
            this._isAdmin = _isAdmin;
            this.personName = personName;
            personId++;

            System.out.println("New person created successfully!");
        }

    }

    //First and last person
    public static Person head = null;
    public static Person tail = null;

    //Creating new person
    public void createNewPerson(String personName, boolean _isAdmin) {
        Person newPerson = new Person(personName, _isAdmin);
        this.personCounter++;

        //Check if the list is empty
        if (head == null) {
            head = newPerson;
            tail = newPerson;
        }
        else {
            tail.next = newPerson;
            tail = newPerson;
        }
    }

    public void banPersonById(int id) {
        Person current = head;
        int personNumber = getPersonCounter();

        if (current == null) {
            System.out.println("Error. There are no people to ban.");
            return;
        }

        while (current != null) {
            if (current._persId == id) { //person is found
                current._isBanned = true;
                System.out.println("Person with id [" + id + "] was banned successfully!");
                return;
            }
            current = current.next;
        }
    }

    public void unbanPersonById(int id) {
        Person current = head;
        int personNumber = getPersonCounter();

        if (current == null) {
            System.out.println("Error. There are no people to unban.");
            return;
        }

        while (current != null) {
            if (current._persId == id) { //person is found
                if (current._isBanned == false) {
                    System.out.println("Person is already unbanned.");
                    return;
                }
                else {
                    current._isBanned = false;
                    System.out.println("Person with id [" + id + "] was unbanned successfully!");
                    return;
                }
            }
            current = current.next;
        }
    }

    public static boolean checkIfPersonIsBannedById(int id) {
        Person current = head;
        int personNumber = getPersonCounter();

        if (current == null) {
            return false;
        }

        while (current != null) {
            if (current._persId == id) { //person is found
                if (current._isBanned == false) { //not banned
                    return false;
                }
                else { //banned
                    return true;
                }
            }
            else if (id == 0) { //If the book is added to the general lib
                return false;
            }
            current = current.next;
        }

        return false;
    }

    public Person findPersonById(int searchedPersonID) {
        Person current = head;
        int personNumber = getPersonCounter();

        if (head == null) {
            System.out.println("Error. There is no people here to search for.");
            return null;
        }

        while (current != null) {
            if (current._persId == searchedPersonID) { //When the person is found by the ID
                return current;
            }
            current = current.next;
        }

        System.out.println("Person with the ID [" + searchedPersonID + "] was not found.\nMaybe you didn't enter the correct ID.");
        return null;
    }

    public void showAllPeople() {
        Person current = head;
        int people = getPersonCounter();

        if (current == null) {
            System.out.println("There are no people here.");
            return;
        }

        System.out.println("Total number of people [" + people + "]");
        while (current != null) {
            System.out.println("Name [" + current.personName + "] isAdmin [" + current._isAdmin + "] ID [" + current._persId + "] isBanned [" + current._isBanned + "]");
            current = current.next;
        }
        System.out.println("\n");
    }

    public static int getPersonCounter() {
        return personCounter;
    }

    public String get_adminPassword() {
        return _adminPassword;
    }


}
