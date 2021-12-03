package com.qa.ims;

import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class EndpointController {
    private final CustomerController customers;
    private final OrderController orders;
    private final ItemController items;
    private final Utils utils;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public EndpointController() {
        this.utils = new Utils();
        final CustomerDAO custDAO = new CustomerDAO();
        final OrderDAO orderDAO = new OrderDAO();
        final ItemDAO itemDAO = new ItemDAO();
        this.customers = new CustomerController(custDAO);
        this.orders = new OrderController(orderDAO, utils);
        this.items = new ItemController(itemDAO, utils);

    }


    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/order/create")
    public Greeting orderCreate(@RequestBody CustomerSpring newOrderSpring) {
        return new Greeting(counter.incrementAndGet(), String.format(template));
    }

    @GetMapping("/order/update")
    public Greeting orderUpdate(@RequestBody CustomerSpring newOrderSpring) {
        return new Greeting(counter.incrementAndGet(), String.format(template));
    }

    @GetMapping("/order/delete")
    public Greeting orderDelete(@RequestBody OrderSpring newOrderSpring) {
        return new Greeting(counter.incrementAndGet(), String.format(template));
    }

    @GetMapping("/customer/create")
    public CustomerSpring customerCreate(@RequestBody CustomerSpring newCustomerSpring) {
        this.customers.create(newCustomerSpring.getFirstName(), newCustomerSpring.getSurname(),
                newCustomerSpring.getEmailAddress(), newCustomerSpring.getPhoneNumber());
        return newCustomerSpring;
    }

    @GetMapping("/customer/delete")
    public CustomerSpring customerDelete(@RequestBody CustomerSpring newCustomerSpring) {
        this.customers.delete(newCustomerSpring.getId());
        return newCustomerSpring;
    }

    @GetMapping("/customer/update")
    public CustomerSpring customerUpdate(@RequestBody CustomerSpring newCustomerSpring) {
        this.customers.update(newCustomerSpring.getId(), newCustomerSpring.getFirstName(), newCustomerSpring.getSurname(),
                newCustomerSpring.getEmailAddress(), newCustomerSpring.getPhoneNumber());
        return newCustomerSpring;
    }

    @GetMapping("/customer/all")
    public List<Customer> customerView(@RequestBody String something) {
        return this.customers.readAll();
    }
}