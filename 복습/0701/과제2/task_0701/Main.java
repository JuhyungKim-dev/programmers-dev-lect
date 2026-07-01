package com.example.spring.springtheory.ch06.task_0701;
import com.example.spring.springtheory.ch06.task_0701.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
        OrderService orderService = ctx.getBean(OrderService.class);
        MemberService memberService = ctx.getBean(MemberService.class);
        ProductService productService = ctx.getBean(ProductService.class);

        System.out.println("===== 주문 =====");
        System.out.println(orderService.placeOrder("키보드"));
        System.out.println("\n===== 회원 =====");
        System.out.println(memberService.register("kim"));
        System.out.println("\n===== 상품 =====");
        System.out.println(productService.getProduct("A-100"));
        System.out.println("\n===== 프록시 확인 =====");
        System.out.println(orderService.getClass());
        ctx.close();
    }
}