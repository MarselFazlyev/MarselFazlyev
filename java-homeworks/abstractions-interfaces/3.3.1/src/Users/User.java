package Users;

import Interfaces.*;


public abstract class User implements Reader, Librarian, Supplier, Administrator {
    protected String name;
    protected String type;

    public User(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return type + " " + name;
    }


}