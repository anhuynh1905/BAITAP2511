package com.BaiTap._1.Controller;

import com.BaiTap._1.Model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableMethodSecurity
public class CustomerController {
    final private List<Customer> customerlist = List.of(
            Customer.builder()
                    .email("anan123@gmail.com")
                    .id("01")
                    .name("An")
                    .phoneNumber("9384920394")
                    .build(),
            Customer.builder()
                    .email("nana123@gmail.com")
                    .id("002")
                    .name("nA")
                    .phoneNumber("0548652015")
                    .build()
    );

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello is guest");
    }

    @GetMapping("/customer/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Customer>> getCustomerList(){
        List<Customer>list = this.customerlist;
        return ResponseEntity.ok(list);
    }

    @GetMapping("/customer/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Customer> getCustomerList(@PathVariable("id") String id){
        List<Customer> customerList = this.customerlist.stream().filter(customer -> customer.getId().equals(id)).toList();
        return ResponseEntity.ok(customerList.get(0));
    }
}
