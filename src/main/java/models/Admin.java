package models;

import java.util.*;
import java.text.*;

public class Admin extends User {

    public Admin(int userId, String userName, String password) {

        this.userId = userId;

        this.userName = userName;

        this.password = password;

        this.role = "Admin";

    }

    public boolean verifyPassword(String currPassword) {

        return password.equals(currPassword);

    }

}
