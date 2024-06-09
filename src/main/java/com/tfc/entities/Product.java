package com.tfc.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @NotBlank @NotNull
    private String name;

    @NotBlank @NotNull
    private int price;

    @NotBlank @NotNull
    private String description;

    @NotBlank @NotNull
    private String image;

    @NotBlank @NotNull
    private String category;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sub_category", nullable = false)
    private SubCategory subCategory;

}
