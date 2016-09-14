package sy.model;

import java.util.Date;

public class Order {
    private Long orderId;

    private Date orderDate;

    private Integer orderIscomplete;

    private Integer orderIscancel;

    private Double orderTotalprice;

    private String orderBuyer;

    private String orderCompleter;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderIscomplete() {
        return orderIscomplete;
    }

    public void setOrderIscomplete(Integer orderIscomplete) {
        this.orderIscomplete = orderIscomplete;
    }

    public Integer getOrderIscancel() {
        return orderIscancel;
    }

    public void setOrderIscancel(Integer orderIscancel) {
        this.orderIscancel = orderIscancel;
    }

    public Double getOrderTotalprice() {
        return orderTotalprice;
    }

    public void setOrderTotalprice(Double orderTotalprice) {
        this.orderTotalprice = orderTotalprice;
    }

    public String getOrderBuyer() {
        return orderBuyer;
    }

    public void setOrderBuyer(String orderBuyer) {
        this.orderBuyer = orderBuyer == null ? null : orderBuyer.trim();
    }

    public String getOrderCompleter() {
        return orderCompleter;
    }

    public void setOrderCompleter(String orderCompleter) {
        this.orderCompleter = orderCompleter == null ? null : orderCompleter.trim();
    }
}