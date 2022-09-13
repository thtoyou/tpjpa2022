package jpa;

import jpa.DAO.ProfDAO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ConcreteUser extends AbstractUser {
    private String name;
    private String passWord;
    private List<Appointment> appointments = new ArrayList<Appointment>();


    public ConcreteUser(String name, String passWord, Long id) {
        this.name = name;
        this.passWord = passWord;
    }

    public ConcreteUser(String name, String passWord) {
        this.name = name;
        this.passWord = passWord;
    }

    public ConcreteUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public Boolean LogIn(Long id, String passWord) {
        return null;
    }

    @Override
    public Boolean LogOut() {
        return null;
    }
    @Override
    public String toString() {
        return "nom :" + name + "id :" + super.getId() ;
    }
}
