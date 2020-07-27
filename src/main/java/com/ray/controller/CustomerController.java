package com.ray.controller;

import com.ray.entity.Customer;
import com.ray.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService cs;

    /*   @GetMapping("/list")
       public String list() {
   */
    @RequestMapping("/list")
    public String listCustomers(Model theModel) {
        //  return "list";
        // get customers from the dao
        List<Customer> theCustomers = cs.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @GetMapping("/addcustomer")
    public String addcustomer(Model model) {
        model.addAttribute(new Customer());
        return "customer_form";

    }
    @GetMapping("/deletecustomer")
    public String deletecustomer(@RequestParam("id") int id, Model mdl) {
        cs.deleteCustomer(id);
        return "redirect:/customer/list";

    }
    @PostMapping("/savecustomer")
    public String savecustomer(@ModelAttribute("Customer") Customer _customer) {
//
        cs.saveCustomer(_customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showformforupdate")
    public String showformforupdate(@RequestParam("id") int id, Model mdl) {
//
        Customer c = cs.getCustomer(id);

        mdl.addAttribute("customer", c);
        return "customer_form";
    }
}
