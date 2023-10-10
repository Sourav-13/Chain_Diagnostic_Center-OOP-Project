/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserClass;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public abstract class Employee extends User implements Serializable {

    protected int phnNo;
    protected String name,  gender, branchName, desig;
    protected LocalDate dob;
    protected float salary;

    public Employee() {
    }

    public Employee(int phnNo, String name, String gender, String branchName, String desig, LocalDate dob, float salary, String password, int id) {
        super(password, id);
        this.phnNo = phnNo;
        this.name = name;
        this.gender = gender;
        this.branchName = branchName;
        this.desig = desig;
        this.dob = dob;
        this.salary = salary;
    }

    public Employee(int phnNo, String name, String gender, String branchName, String desig, LocalDate dob) {
        this.phnNo = phnNo;
        this.name = name;
        this.gender = gender;
        this.branchName = branchName;
        this.desig = desig;
        this.dob = dob;  
    }

    
    @Override
    public String toString() {
        return  ", phnNo= " + phnNo
                + ", name= " + name + " , desig= " + desig + ", gender= " + gender
                + ", branchName= " + branchName 
                + ", dob= " + dob ;
    }

    public int getPhnNo() {
        return phnNo;
    }

    public void setPhnNo(int phnNo) {
        this.phnNo = phnNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

}
