package com.example.Scheme.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name="Account_details")
public class Accountdetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String accountholder;
    private String accountno;
    private String ifsc;
    private String bankname;
    private double amount;
    private long mobileno;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDate lastInterestAppliedDate;
}
