package com.example.demo.service;

public interface InventoryAction {
    boolean reduce(String businessKey, int count);
    boolean compensateReduce(String businessKey);
}
