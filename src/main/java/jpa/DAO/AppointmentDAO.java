package jpa.DAO;

import jpa.AbstractUser;
import jpa.Appointment;
import jpa.EntityManagerHelper;
import jpa.Prof;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.sql.Time;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = "Appointment.findById", query = "select a from Appointment a where a.id = :Id")
})
public class AppointmentDAO extends AbstractJpaDao {
    static EntityManager em = EntityManagerHelper.getEntityManager();
    Query query = new Query();

    public AppointmentDAO(Appointment appointment) {
        super(Appointment.class);
    }

    public static boolean makeAppointment(AbstractUser u, Prof p) {
        Date start = new Date(2023, 01, 01, 8, 0);
        Time length = new Time(1);
        Appointment rdv = new Appointment(start, length, p, u);
        em.createNativeQuery("insert into Appointment(rdv) value (?) ", Appointment.class)
                .setParameter("Appointment", rdv).executeUpdate();
        return true;
    }

    public static Appointment getAppointmentById(long id) {
       Appointment app = em.createNamedQuery("Appointment.findByProf_Appointments_Id").
                setParameter(id).getSingleResult();
        return app;
    }
}
