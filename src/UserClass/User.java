/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserClass;

import java.io.Serializable;


public class User implements Serializable {

    protected String password;
    protected int id;

    public User() {
    }

    public User(String password, int id) {
        this.password = password;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" + "password=" + password + ", id=" + id + '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
