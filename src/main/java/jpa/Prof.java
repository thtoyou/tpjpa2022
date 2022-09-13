package jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Prof extends AbstractUser implements Serializable {

    String name;
    String passWord;
    String poste;

    Time length;
    List<Appointment> appointments = new ArrayList<Appointment>();

    public Prof(String name, String passWord, String poste, Time length) {
        this.name = name;
        this.passWord = passWord;
        this.poste = poste;
        this.length = length;
    }

    public Prof() {
    }

    @Basic
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Time getLength() {
        return length;
    }

    public void setLength(Time length) {
        this.length = length;
    }

    @OneToMany(mappedBy = "prof", cascade = CascadeType.ALL)
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public Boolean LogIn(Long id, String pass) {
        //appel à la base de donnée pour vérification
        return null;
    }

    @Override
    public Boolean LogOut() {
        //fermeture de la session
        return null;
    }

}
