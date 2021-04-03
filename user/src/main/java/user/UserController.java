package user;


import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Vodila> getListOfUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Vodila getUserById(@PathVariable(name = "id") Long id){
        return userService.getUserById(id).orElse(new Vodila());
    }

    @DeleteMapping(value = "{id}")
    public void deleteUserById(@PathVariable(name = "id") Long id){
        userService.deleteUserById(id);
    }

    @PostMapping
    public Vodila saveEmail(@RequestBody Vodila vodila){
        return userService.saveUser(vodila);
    }

}
