package burin17.marketplaceuserservice.controller;

import burin17.marketplaceuserservice.model.User;
import burin17.marketplaceuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public User user(@PathVariable Long userId) {
        return userService.userById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User userData) {
        return userService.createUser(userData);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User userData) {
        return userService.updateUser(userId, userData);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
