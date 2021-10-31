package com.example.demo;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now().minusHours(1).format(
                DateTimeFormatter.ISO_ZONED_DATE_TIME
        ));
    }
}
