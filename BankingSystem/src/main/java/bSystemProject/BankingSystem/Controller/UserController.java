package bSystemProject.BankingSystem.Controller;

import bSystemProject.BankingSystem.Model.UserInfo;
import bSystemProject.BankingSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/new_user")
    public String createNewUser(@RequestBody UserInfo userInfo){
        return userService.createUser(userInfo);
    }

    @GetMapping
    public List<UserInfo> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/{ID}")
    public String deleteUserID(@PathVariable Integer ID){
        return userService.deleteUserID(ID);
    }

    @DeleteMapping("/Delete")
    public String deleteAllUser(){
        return userService.deleteAll();
    }

}
