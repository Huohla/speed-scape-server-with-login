package com.tfc.entities;

import com.tfc.enums.TransactionEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<Product> product;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private GameUser user;

    @NotNull
    @Enumerated(EnumType.STRING)
    TransactionEnum type;
}
