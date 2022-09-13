package jpa;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "Appointment.findByProf_Appointments_Id", query = "select a from Appointment a inner join a.prof.appointments appointments where appointments.id = :Id")
})

public class Appointment {
    Date start;
    Time length;
    Prof prof;
    AbstractUser user;
    Long Id;

    public Appointment(Date start, Time length, Prof prof, AbstractUser user) {
        this.start = start;
        this.length = length;
        this.prof = prof;
        this.user = user;
    }

    public Appointment() {
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Time getLength() {
        return length;
    }

    public void setLength(Time length) {
        this.length = length;
    }

    @ManyToOne
    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    @ManyToOne
    public AbstractUser getUser() {
        return user;
    }

    public void setUser(AbstractUser user) {
        this.user = user;
    }


    public void Cancel() {
        this.prof = null;
        this.user = null;
    }

    @Override
    public String toString() {
        return "Appointment at " + start + "with" + prof + "and" + user + "for" + length;
    }


}
