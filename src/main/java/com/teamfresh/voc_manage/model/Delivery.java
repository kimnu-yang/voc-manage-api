package com.teamfresh.voc_manage.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "delivery")
public class Delivery {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String detail;
    private LocalDateTime regDate;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonManagedReference
    private Client client;

    @ManyToOne
    @JoinColumn(name = "workerId")
    @JsonManagedReference
    private Worker worker;
}
