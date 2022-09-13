package jpa.DAO;

import jpa.AbstractUser;
import jpa.EntityManagerHelper;

import jpa.Prof;
import jpa.User;

import javax.persistence.EntityManager;

public class UserDao extends AbstractJpaDao<Long, User> {
    static EntityManager em = EntityManagerHelper.getEntityManager();

    public UserDao(User user) {
        super(User.class);
    }
}
