package com.teamfresh.voc_manage.model;

import com.teamfresh.voc_manage.model.enum_data.ArisenFrom;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "voc")
public class Voc {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reason;
    private LocalDateTime regDate;

    @Enumerated(EnumType.STRING)
    private ArisenFrom arisenFrom;

    @ManyToOne
    @JoinColumn(name = "deliveryId")
    @JsonManagedReference
    private Delivery delivery;
}