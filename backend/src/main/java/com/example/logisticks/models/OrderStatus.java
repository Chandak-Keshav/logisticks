package com.example.logisticks.models;

public class OrderStatus {

    public static enum Status{
        DISPATCHED,
        ARRIVED,
        OUTFORDELIVERY,
        DELIVERED
    }
    private int orderId;
    private int currentLocationId;
    private Status status;

    public OrderStatus(int orderId, int currentLocationId, Status status) {
        this.orderId = orderId;
        this.currentLocationId = currentLocationId;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCurrentLocationId() {
        return currentLocationId;
    }

    public Status getStatus() {
        return status;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public void setCurrentLocationId(int currentLocationId) {
        this.currentLocationId = currentLocationId;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
