package com.qa.ims.persistence.dao;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderItemDAO implements Dao<OrderItem>{

   public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<OrderItem> readAll() {
        try (Connection connection = DBUtils.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM OrdersItems");) {
            List<OrderItem> items = new ArrayList<>();
            while (resultSet.next()) {
                items.add(modelFromResultSet(resultSet));
            }
            return items;
        } catch (SQLException e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public OrderItem read(Long orderItemId) {
        try (Connection connection = DBUtils.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM OrdersItems WHERE OrderItemsID = ?");) {
            statement.setLong(1, orderItemId);
            try (ResultSet resultSet = statement.executeQuery();) {
                resultSet.next();
                return modelFromResultSet(resultSet);
            }
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public OrderItem create(OrderItem t) {
        try (Connection connection = DBUtils.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("INSERT INTO OrdersItems(ItemID, OrderID) VALUES (?, ?)");) {
            statement.setLong(1, t.getItemId());
            statement.setLong(2, t.getOrderId());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public OrderItem update(OrderItem t) {
        try (Connection connection = DBUtils.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("UPDATE OrdersItems SET ItemID = ?, OrderID = ? WHERE OrderItemsID = ?");) {
            statement.setLong(1, t.getItemId());
            statement.setLong(2, t.getOrderId());
            statement.setLong(3, t.getOrderItemId());
            statement.executeUpdate();
            return read(t.getOrderItemId());
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public int delete(long orderItemsID) {
        try (Connection connection = DBUtils.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM OrdersItems WHERE OrderItemsID = ?");) {
            statement.setLong(1, orderItemsID);
            return statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

    @Override
    public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {
        Long OrderItemId = resultSet.getLong("OrderItemsID");
        Long itemID = resultSet.getLong("ItemID");
        Long OrderID = resultSet.getLong("OrderID");
        return new OrderItem(OrderItemId, itemID, OrderID);
    }

    private OrderItem readLatest() {
        try (Connection connection = DBUtils.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM OrdersItems ORDER BY OrderItemsID DESC LIMIT 1");) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }
    
}
