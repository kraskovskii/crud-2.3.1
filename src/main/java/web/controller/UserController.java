package web.controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/index";
    }

    @PostMapping()
    public String creatUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}")
    public String getUser(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("users", userService.getUserById(id));
        return "users/index";
    }

    @GetMapping(value = "/new")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "users/new";
    }


    @GetMapping(value = "{id}/delete")
    public String deleteUser(@ModelAttribute("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser(ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("userForEdit", userService.getUserById(id));
        System.out.println(userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User updateUser) {
        userService.updateUser(updateUser);
        System.out.println(updateUser);
        return "redirect:/users";
    }
}
