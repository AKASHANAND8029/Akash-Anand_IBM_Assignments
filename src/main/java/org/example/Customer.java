package org.example;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private int accountNumber;
    private String customerName;

    private int balance;

    private String username;
    private int password;

}


