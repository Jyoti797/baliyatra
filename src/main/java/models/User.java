package models;

import java.util.*;
import java.text.*;

abstract class User {

    protected int userId;

    protected String userName;

    protected String password;

    protected String role;

    public int getUserId() {

        return userId;

    }

    public String getRole() {

        return role;

    }

}
