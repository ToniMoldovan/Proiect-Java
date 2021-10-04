public class Person {
    

    class About {
        String personName;
        private int _personID;
        private boolean _isAdmin;
        int age;

        private int[] personalPenalties = new int[3];

        public About(String personName, int _personID, boolean _isAdmin, int age) {
            this.personName = personName;
            this._personID = _personID;
            this._isAdmin = _isAdmin;
            this.age = age;
        }
    }

    About about;

//    public Person(String personName, int _personID, boolean _isAdmin, int age) {
//        this.about = new About();
//    }


}
