package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

public interface CarDao {
    void add(Car car);
    User getUserByCarModel(String carModel, int series);
}
