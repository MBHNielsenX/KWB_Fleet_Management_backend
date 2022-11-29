package com.example.kwbruunauktion.auktionSystem.entity;

import com.example.kwbruunauktion.auktionSystem.entity.users.UserBuyer;
import com.example.kwbruunauktion.auktionSystem.entity.users.UserLeaser;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class SpecificCarModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100, nullable = false)
  private String brand;

  @Column(length = 100, nullable = false)
  private String model;

  @Column(length = 100, nullable = false)
  private String modelYear;

  @JoinTable(name = "specificCarModelMembers", joinColumns = @JoinColumn(name = "specificCarModel_id",columnDefinition = "varchar(255) default 'no value'"), inverseJoinColumns = @JoinColumn(name = "userLeaser_id",columnDefinition = "varchar(255) default 'no value'"))
  @ManyToMany
  @ToString.Exclude
  private List<UserBuyer> userBuyer;

  @JoinTable(name = "specificCarModelMembers", joinColumns = @JoinColumn(name = "specificCarModel_id",columnDefinition = "varchar(255) default 'no value'"), inverseJoinColumns = @JoinColumn(name = "userLeaser_id",columnDefinition = "varchar(255) default 'no value'"))
  @ManyToMany
  @ToString.Exclude
  private List<UserLeaser> userLeaser;

  @OneToOne(mappedBy = "specificCarModel")
  private BrandColorMix brandColorMix;


  public void addUserBuyer(UserBuyer u) {
    userBuyer.add(u);
    u.getViewableCarBrands().add(this);
  }
  public void addUserLeaser(UserLeaser u) {
    this.userLeaser.add(u);
    u.getViewableCarBrands().add(this);
  }
}
