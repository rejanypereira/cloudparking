package br.com.cloudparking.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "PARKING")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String license;
    @Column
    private String state;
    @Column
    private String model;
    @Column
    private String color;
    @Column
    private LocalDateTime entryDate;
    @Column
    private LocalDateTime exitDate;
    @Column
    private Double bill;
}
