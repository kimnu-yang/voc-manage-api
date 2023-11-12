package com.teamfresh.voc_manage.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "worker")
public class Worker {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contact;

    @ManyToOne
    @JoinColumn(name = "transportId")
    @JsonManagedReference
    private Transport transport;
}
