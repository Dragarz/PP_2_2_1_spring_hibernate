package hiber.dao;

import java.util.List;
import hiber.model.Car;
import hiber.model.User;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public User getUserByCarModel(String carModel, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery( "select c.user from Car c WHERE model = :carModel AND series = :series", User.class);
        query.setParameter("carModel", carModel);
        query.setParameter("series", series);

        List<User> result = query.getResultList();

        return result.isEmpty() ? null : result.get(0);
    }
}
