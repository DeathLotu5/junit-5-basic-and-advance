package com.appsdeveloperblog;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//Bởi vì mỗi 1 method test được chạy thì 1 class mới
// sẽ được tạo ra. Để tạo 1 class duy nhất chạy các test class để chia sẻ trạng thái biến hay method, chúng ta sẽ dùng annotation này
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MethodOrderedOrderIndexTest {

    StringBuilder conpleted = new StringBuilder("");

    @AfterEach
    void afterEach() {
        System.out.println("The state of instance object is: " + conpleted);
    }

    @Test
    @Order(1)
    void testD() {
        System.out.println("Running test D");
        conpleted.append("1");
    }

    @Test
    @Order(2)
    void testA() {
        System.out.println("Running test A");
        conpleted.append("2");
    }


    @Test
    @Order(4)
    void testC() {
        System.out.println("Running test C");
        conpleted.append("3");
    }

    @Test
    @Order(3)
    void testB() {
        System.out.println("Running test B");
        conpleted.append("4");
    }



}
