package spring.intro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.intro.config.AppConfig;
import spring.intro.model.User;
import spring.intro.service.UserService;

public class Main {
    public static void main(String[] args) {
        var applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        var userService = applicationContext.getBean(UserService.class);

        var bob = new User("bob@mail.com", "1");
        var alice = new User("alice@mail.com", "2");
        userService.add(bob);
        userService.add(alice);

        var users = userService.listUsers();
        users.forEach(System.out::println);
    }
}
