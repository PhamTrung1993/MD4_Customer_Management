package com.controller;

import com.model.Customer;
import com.service.ICustomerService;
import com.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {

    private CustomerService customerService = new CustomerService();

    @Controller
    @RequestMapping("/customers")
    public class customerController {
        @Autowired
        private ICustomerService customerService;

        @GetMapping()
        public ModelAndView getAllStudent() {
            ModelAndView modelAndView = new ModelAndView("/customer/list");
            List<Customer> customers = customerService.findAll();
            modelAndView.addObject("customers", customers);
            return modelAndView;
        }

        @GetMapping("/create")
        public ModelAndView showFormCreateStudent() {
            ModelAndView modelAndView = new ModelAndView("/customer/create");
            modelAndView.addObject("customer", new Customer());
            return modelAndView;
        }

        @PostMapping("/create")
        public ModelAndView createStudent(@ModelAttribute Customer customer) {
            ModelAndView modelAndView = new ModelAndView("/customer/create");
            customerService.save(customer);
            modelAndView.addObject("mess", "Tao moi thanh cong");
            return modelAndView;


        }
    }
}
