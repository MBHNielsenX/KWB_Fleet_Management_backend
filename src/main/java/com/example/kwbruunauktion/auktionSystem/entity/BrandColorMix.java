package com.example.kwbruunauktion.auktionSystem.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class BrandColorMix {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  private SpecificCarModel specificCarModel;

  @OneToOne(cascade = CascadeType.ALL)
  private ColorMix colorMix;

  @Column(length = 30, nullable = false)
  private double price;
}