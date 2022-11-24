package com.example.kwbruunauktion.auktionSystem.entity;

import com.example.kwbruunauktion.auktionSystem.enums.CampaignStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne (cascade = CascadeType.ALL)
    private CampaignCar campaignCar;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100)
    private CampaignStatus campaignStatus;

    @Column(nullable = false, length = 100)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate activeDate;

    @OneToMany (mappedBy = "campaign")
    @ToString.Exclude
    private List<LcdvCodes> lcdvCodes = new ArrayList<>();
}