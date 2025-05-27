package hiber.service;

import java.util.List;
import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    @Transactional
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByCarModel(String carModel, int series) {
        return carDao.getUserByCarModel(carModel, series);
    }
}
