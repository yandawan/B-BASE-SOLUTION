package com.example.demo.service;

public interface BalanceAction {
    boolean reduce(String businessKey, Integer amount);
    boolean compensateReduce(String businessKey);
}
