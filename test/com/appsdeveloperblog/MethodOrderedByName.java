package com.appsdeveloperblog;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.DisplayName.class)
class MethodOrderedByName {

    @Test
    void testD() {
        System.out.println("Running test D");
    }

    @Test
    void testA() {
        System.out.println("Running test A");
    }


    @Test
    void testC() {
        System.out.println("Running test C");
    }

    @Test
    void testB() {
        System.out.println("Running test B");
    }
}
