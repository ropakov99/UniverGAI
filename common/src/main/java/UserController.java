import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/v1/gai/users")
public class UserController {

//    @Autowired
//    private UserService userService;
//
//
//    @GetMapping
//    public List<User> getUsers() {
//        return userService.findAll();
//    }
}