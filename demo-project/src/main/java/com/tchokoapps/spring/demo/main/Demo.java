package com.tchokoapps.spring.demo.main;

import com.tchokoapps.spring.demo.beans.Vehicle;
import com.tchokoapps.spring.demo.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Honda City");
        System.out.println("Vehicle name from non-spring-context is: " + vehicle.getName());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Vehicle vehicle2 = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from spring-context is: " + vehicle2.getName());

        Vehicle vehicle3 = context.getBean("vehicle3", Vehicle.class);
        System.out.println("Vehicle name from spring-context is: " + vehicle3.getName());
    }
}
