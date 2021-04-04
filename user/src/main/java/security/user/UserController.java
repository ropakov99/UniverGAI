package security.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
@RequestMapping("/user")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping
    public List<User> getListOfUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(name = "id") Long id){
        return userService.getUserById(id).orElse(new User());
    }

    @DeleteMapping(value = "{id}")
    public void deleteUserById(@PathVariable(name = "id") Long id){
        userService.deleteUserById(id);
    }

    @PostMapping
    public User saveEmail(@RequestBody User user){
        return userService.saveUser(user);
    }

}
