package interview.drills.sortObjects;

import java.time.LocalDate;

public class OrderO {
    int orderId;
    LocalDate orderDate;
    double price;
    String category;
    LocalDate deliveryDate;
    long pinCode;

    public OrderO(int orderId, LocalDate orderDate, double price, String category, LocalDate deliveryDate, long pinCode) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.price = price;
        this.category = category;
        this.deliveryDate = deliveryDate;
        this.pinCode = pinCode;
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public long getPinCode() {
        return pinCode;
    }

    @Override
    public String toString() {
        return "OrderO{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", pinCode=" + pinCode +
                '}';
    }
}
