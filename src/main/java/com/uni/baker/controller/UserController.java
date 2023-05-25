package com.uni.baker.controller;

import com.uni.baker.entity.Category;
import com.uni.baker.entity.User;
import com.uni.baker.service.CategoryService;
import com.uni.baker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String showAllUsers(Model model) {
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "admin/user/list";
    }
    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.getAllUser());
        return "admin/user/add";
    }
    @PostMapping("/add")
    public String addUser(@ModelAttribute("category") User user, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "admin/user/add";
        }
        userService.addUser(user);
        return "redirect:/admin/users";
    }
    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        User editUser = userService.getUserById(id);
        model.addAttribute("users", userService.getAllUser());
        if(editUser != null) {
            model.addAttribute("user", editUser);
            return "admin/user/edit";
        }else{
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User updatedUser) {
        userService.updateUser(updatedUser);
        return "redirect:/admin/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserForm(@PathVariable("id") Long id, Model model) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

}
