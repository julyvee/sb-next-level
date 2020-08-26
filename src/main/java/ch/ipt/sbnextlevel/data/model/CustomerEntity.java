package ch.ipt.sbnextlevel.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerEntity {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    @Id
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}