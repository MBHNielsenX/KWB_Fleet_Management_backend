package com.example.kwbruunauktion.auktionSystem.dto;

import com.example.kwbruunauktion.auktionSystem.entity.Ownership;
import com.example.kwbruunauktion.auktionSystem.entity.UserAdmin;
import com.example.kwbruunauktion.auktionSystem.entity.UserEconomy;
import com.example.kwbruunauktion.auktionSystem.entity.users.UserBuyer;
import com.example.kwbruunauktion.auktionSystem.entity.users.UserLeaser;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuperBuilder

public class OwnershipRequest {

    private long id;

    private String name;

    private String abbreviation;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",shape = JsonFormat.Shape.STRING)
    private LocalDateTime created;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",shape = JsonFormat.Shape.STRING)
    private LocalDateTime updated;

    public OwnershipRequest(long id, String name, String abbreviation, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.created = created;
        this.updated = updated;
    }
}
