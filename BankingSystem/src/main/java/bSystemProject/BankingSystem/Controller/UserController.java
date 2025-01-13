package bSystemProject.BankingSystem.Controller;

import bSystemProject.BankingSystem.Module.BankAccount;
import bSystemProject.BankingSystem.Module.UserInfo;
import bSystemProject.BankingSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{ID}")
    public Optional<UserInfo> getUserNameByID(@PathVariable Integer ID) {
        return userService.getUserNameById(ID);
    }

    @DeleteMapping("/{ID}")
    public String deleteUserID(@PathVariable Integer ID){
        return userService.deleteUserID(ID);
    }

    @PostMapping("/new_user")
    public String createNewUser(@RequestBody UserInfo userInfo){
        return userService.createUser(userInfo);
    }

    @GetMapping
    public List<UserInfo> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/user/with_account")
    public String createUser(@RequestBody UserInfo user) {
        userService.saveUserWithBankAccounts(user);
        return "Ok";
    }

}
