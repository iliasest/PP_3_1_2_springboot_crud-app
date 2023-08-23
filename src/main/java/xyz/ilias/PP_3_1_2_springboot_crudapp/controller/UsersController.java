package xyz.ilias.PP_3_1_2_springboot_crudapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xyz.ilias.PP_3_1_2_springboot_crudapp.model.User;
import xyz.ilias.PP_3_1_2_springboot_crudapp.service.UserService;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("usersList", userService.getAllUsers());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userService.getById(id));
        modelAndView.setViewName("/show");
        return modelAndView;
    }

    @GetMapping("users/new")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView create(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");

        userService.add(user);

        return modelAndView;
    }

    @GetMapping("users/{id}/edit")
    public ModelAndView editUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("user", userService.getById(id));

        return modelAndView;
    }

    @PatchMapping("users/{id}")
    public ModelAndView update(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");

        userService.edit(user);

        return modelAndView;
    }

    @DeleteMapping("users/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");

        userService.delete(id);

        return modelAndView;
    }
}
