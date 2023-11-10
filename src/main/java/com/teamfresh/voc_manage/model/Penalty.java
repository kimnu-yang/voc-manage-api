package com.teamfresh.voc_manage.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.teamfresh.voc_manage.model.enum_data.ConfirmStatus;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "penalty")
public class Penalty {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer fine;
    private String comment;
    private LocalDateTime regDate;
    private LocalDateTime confirmDate;

    @Enumerated(EnumType.STRING)
    private ConfirmStatus confirm;

    @ManyToOne
    @JoinColumn(name = "compensationId")
    @JsonManagedReference
    private Compensation compensation;
}