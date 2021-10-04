import java.util.Objects;
import java.util.Scanner;

public class People {
    int personCounter = 0;

    Library library = new Library();

    static class Person {
        private int _personId;
        private boolean _isAdmin;

        String personName;

        Person next;

        //Constructor
        public Person(String personName, int _personId, boolean _isAdmin) {
            this._personId = _personId;
            this._isAdmin = _isAdmin;
            this.personName = personName;

            System.out.println("New person created successfully!");
        }
    }

    //First and last person
    public Person head = null;
    public Person tail = null;

    //Creating new person
    public void createNewPerson(String personName, int _personId, boolean _isAdmin) {
        Person newPerson = new Person(personName, _personId, _isAdmin);
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



    //Display all people
    public void showAllPeople() {
        Person current = head;
        int people = getPersonCounter();

        if (current == null) {
            System.out.println("There are no people here.");
            return;
        }

        while (current != null) {
            System.out.println("[" + people + "] Name [" + current.personName + "] isAdmin [" + current._isAdmin + "] ID [" + current._personId + "]\n");
            current = current.next;
        }
    }

    public int getPersonCounter() {
        return personCounter;
    }
}
