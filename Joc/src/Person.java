public class Person {
    String personName;
    private int _personLibraryId;
    private boolean personIsAdmin;

    public Person(String personName, int _personLibraryId, boolean personIsAdmin) {
        this.personName = personName;
        this._personLibraryId = _personLibraryId;
        this.personIsAdmin = personIsAdmin;
    }
}
