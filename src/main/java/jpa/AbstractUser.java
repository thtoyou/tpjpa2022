package jpa;

import jpa.DAO.AppointmentDAO;
import jpa.DAO.ProfDAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AbstractUser implements User{
    private Long id;
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Boolean LogIn(Long id, String pass) {
        return null;
    }

    @Override
    public Boolean LogOut() {
        return null;
    }

    @Override
    public Boolean makeAppointment(Prof P) {
       return AppointmentDAO.makeAppointment(this,P);
    }
}
