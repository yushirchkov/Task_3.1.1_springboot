package springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.model.User;
import springboot.service.UserService;

@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/users/new")
    public String newUser(@ModelAttribute("user") User user){
        return "new";
    }

    @GetMapping(value = "/users")
    public String printUsers(Model model){
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping(value = "/users{id}")
    public String getUsersById(@PathVariable("id") int n, Model model){
        model.addAttribute(userService.getUserById(n));
        return "userId";
    }

    @GetMapping(value = "/users/{id}/update")
    public String update(Model model, @PathVariable("id") int n){
        model.addAttribute("user", userService.getUserById(n));
        return "update";
    }

    @PatchMapping(value = "users/{id}")
    public String update1(@ModelAttribute("user") User user, @PathVariable("id") int id){
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "users/{id}")
    public String delete(@PathVariable("id") int n){
        userService.delete(n);
        return "redirect:/users";
    }

}
