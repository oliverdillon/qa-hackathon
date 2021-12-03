package com.qa.ims.controller;

import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderItemController implements CrudController<OrderItem> {

    public static final Logger LOGGER = LogManager.getLogger();

    private OrderItemDAO orderItemDAO;
    private Utils utils;

    public OrderItemController(OrderItemDAO orderItemDAO, Utils utils) {
        super();
        this.orderItemDAO = orderItemDAO;
        this.utils = utils;
    }

    @Override
    public List<OrderItem> readAll() {
        List<OrderItem> orderItems = orderItemDAO.readAll();
        return orderItems;
    }

    public OrderItem create(OrderItem oi) {
        OrderItem orderItem = orderItemDAO.create(new OrderItem(oi.getItemId(), oi.getOrderId()));
        return orderItem;
    }

    @Override
    public int delete() {
        LOGGER.info("Item has been deleted from the order");
        Long id = utils.getLong();
        return orderItemDAO.delete(id);
    }

    @Override
    public OrderItem create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderItem update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

//    public OrderItem update(OrderItem oi) {
//        LOGGER.info("Please enter the id of the item you would like to update");
//        Long id = utils.getLong();
//        LOGGER.info("Please enter a item name");
//        String name = utils.getString();
//        LOGGER.info("Please enter a price");
//        Double price = utils.getDouble();
//        Item item = itemDAO.update(new Item(id, name, price));
//        return item;
//    }