package jpa;

import jpa.DAO.AppointmentDAO;
import jpa.DAO.ProfDAO;
import jpa.DAO.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JpaTest {


    /**
     * @param args
     */
    public static void main(String[] args) {

        List plan = new ArrayList<>();
        Time length = new Time(1);
        Date date = new Date(2023,01,01);
        User user1 = new ConcreteUser("qqn1", "qqch1");
        User user2 = new ConcreteUser("qqn2", "qqch2");
        User user3 = new ConcreteUser("qqn3", "qqch3");
        User user4 = new Prof("1prof", "1pass", "info", length);
        User user5 = new Prof("prof2", "pass", "bio", length);
        Appointment appointment = new Appointment(date,length,(Prof)user4,(AbstractUser) user1);
        UserDao user1Dao = new UserDao(user1);
        UserDao user2Dao = new UserDao(user2);
        UserDao user3Dao = new UserDao(user3);
        ProfDAO prof1Dao = new ProfDAO(user4);
        ProfDAO prof2Dao = new ProfDAO(user5);


        try {
            user1Dao.save(user1);
            user2Dao.save(user2);
            user3Dao.save(user3);
            prof1Dao.save((Prof) user4);
            prof2Dao.save((Prof) user5);
            AppointmentDAO.getAppointmentById((long)1);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
