package jpa;

import java.io.Serializable;

public interface User extends Serializable {

    Boolean LogIn(Long id, String pass);
    Boolean LogOut();
    Boolean makeAppointment(Prof P);

}
