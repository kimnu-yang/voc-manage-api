package com.teamfresh.voc_manage.model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lend")
public class Lend {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant startOn;
    private Instant dueOn;

    @Enumerated(EnumType.ORDINAL)
    private LendStatus status;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonManagedReference
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonManagedReference
    private Member member;

    public void setMember(Member member2) {
    }

    public void setBook(Book book2) {
    }

    public void setStatus(LendStatus burrowed) {
    }

    public void setStartOn(Instant now) {
    }

    public void setDueOn(Instant plus) {
    }
}
