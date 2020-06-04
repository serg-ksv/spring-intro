package spring.intro.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.dto.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.UserService;

@RestController
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(this::getDtoFromUser)
                .collect(Collectors.toList());
    }

    @RequestMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        return getDtoFromUser(userService.get(userId));
    }

    @RequestMapping("/inject")
    public void injectData() {
        var jackson = new User("Jackson", "jackson@mail.com", "1");
        var jason = new User("Jason", "jason@mail.com", "2");
        var rick = new User("Rick", "rick@mail.com", "3");
        var morty = new User("Morty", "morty@mail.com", "4");
        userService.add(jackson);
        userService.add(jason);
        userService.add(rick);
        userService.add(morty);
    }

    private UserResponseDto getDtoFromUser(User user) {
        var dto = new UserResponseDto();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
