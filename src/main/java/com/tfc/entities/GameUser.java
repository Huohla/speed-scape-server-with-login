package com.tfc.entities;

import java.util.UUID;

import com.tfc.enums.RoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UuidGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "game_user")
public class GameUser {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @NotNull
    @NaturalId
    @Column(unique = true)
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private Long points;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
}