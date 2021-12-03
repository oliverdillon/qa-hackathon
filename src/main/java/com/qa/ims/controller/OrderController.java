package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

    public static final Logger LOGGER = LogManager.getLogger();

    private OrderDAO OrderDao;
    private Utils utils;

    public OrderController(OrderDAO orderDao, Utils utils) {
        super();
        this.OrderDao = OrderDao;
        this.utils = utils;
    }

    /**
     * Reads all customers to the logger
     */
    @Override
    public List<Order> readAll() {
        List<Order> orders = OrderDao.readAll();
        for (Order order : orders) {
            LOGGER.info(order);
        }
        return orders;
    }

    /**
     * Creates a customer by taking in user input
     */
    @Override
    public Order create() {
        LOGGER.info("Please enter customer id");
        Long customerId = utils.getLong();
        Double totalCost = 0.0;
        Order order = OrderDao.create(new Order(customerId, totalCost));
        LOGGER.info("order created");
        return order;
    }

    /**
     * Deletes an existing customer by the id of the customer
     *
     * @return
     */
    @Override
    public int delete() {
        LOGGER.info("Please enter the id of the customer you would like to delete");
        Long id = utils.getLong();
        return OrderDao.delete(id);
    }

    @Override
    public Order update() {
// TODO Auto-generated method stub
        return null;
    }

}
