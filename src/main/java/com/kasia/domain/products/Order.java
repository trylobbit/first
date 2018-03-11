package com.kasia.domain.products;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by kasia on 09.03.18.
 */
@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "tb_order_order_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "order_item_id"))
    private Set<OrderItem> orderItems;

    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public Order(User user, Set<OrderItem> orderItem) {
        this.user = user;
        this.orderItems = orderItem;

    }

    public Set<OrderItem> getOrderItem() {
        return orderItems;
    }

    public void setOrdertItem(OrderItem productItem) {
        this.orderItems = orderItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
