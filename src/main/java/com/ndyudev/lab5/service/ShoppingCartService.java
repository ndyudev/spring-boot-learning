package com.ndyudev.lab5.service;

import com.ndyudev.lab5.model.Item;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface ShoppingCartService {
    /**
     * Thêm sản phẩm vào giỏ hàng
     * @param item
     * @return item đã thêm
     */
    Item add(Item item);

    /**
     * Xóa sản phẩm khỏi giỏ hàng
     * @param id
     */
    void remove(Integer id);

    /**
     * Cập nhật số lượng sản phẩm trong giỏ hàng
     * @param id
     * @param quantity
     * @return
     */
    Item update(Integer id, Integer quantity);

    /**
     * Xóa toàn bộ sản phẩm trong giỏ hàng
     */
    void clear();
    /**
     * Lấy danh sách sản phẩm trong giỏ hàng
     * @return collection of items
     */
    Collection<Item> getItems();
    /**
     * Lấy tổng số sản phẩm trong giỏ hàng
     * @return count of items
     */
    Integer getCount();
    /**
     * Lấy tổng thành tiền của giỏ hàng
     * @return amount
     */
    double getAmount();

    /**
     * Thanh toán giỏ hàng
     */
    void checkout();
}
