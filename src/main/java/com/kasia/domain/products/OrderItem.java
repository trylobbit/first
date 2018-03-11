package com.kasia.domain.products;

import javax.persistence.*;

/**
 * Created by kasia on 09.03.18.
 */
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_item_id")
    private int id;

    private int amount;

    @OneToOne
    private Product product;
//
//    @ManyToOne
//    private Order order;

    public OrderItem(Product product, Integer amount) {
        this.amount = amount;
        this.product = product;
    }

//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
