package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"), new Car("BMW", 5));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"), new Car("Vaz", 5));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"), new Car("Zil", 5));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"), new Car("Tesla", 5));

      List<User> users = userService.listUsers();
      User userByCar = carService.getUserByCarModel("BMW", 5);

     System.out.println("User by Car name = " + userByCar.getFirstName());

      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car Model = "+user.getCar().getModel());
      }

      context.close();
   }
}
