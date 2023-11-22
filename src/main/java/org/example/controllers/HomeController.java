package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.data.entities.Customer;
import org.example.data.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CustomerRepository customerRepository;

    @GetMapping("/")
    public String getHome(Model model) {
        return "about";
    }

    @GetMapping("/about")
    public String getAbout(Model model) {
        return "about";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "admin";
    }

    @GetMapping("/info")
    public String getInfo(Model model) {
        Iterable<Customer> customersIterable = this.customerRepository.findAll();
        List<Customer> customers = new ArrayList<>();
        customersIterable.forEach(customers::add);
        customers.sort(Comparator.comparing(Customer::getName));
        model.addAttribute("customers", customers);
        model.addAttribute("module", "customers");

        return "info";
    }
}
