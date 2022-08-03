package org.example.bank.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table
@Setter
@Getter
@Entity
public class BankAccount {
    @Id
    @GeneratedValue
    private int id;
    // Must generate id in run

    @Basic
    private String accountName;
    private Double accountBalance;
    private String accountAddress;


    // Use for loop to create accounts
}
