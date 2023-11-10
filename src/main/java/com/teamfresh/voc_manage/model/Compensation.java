package com.teamfresh.voc_manage.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "compensation")
public class Compensation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer amount;
    private String detail;
    private LocalDateTime regDate;

    @ManyToOne
    @JoinColumn(name = "vocId")
    @JsonManagedReference
    private Voc voc;
}