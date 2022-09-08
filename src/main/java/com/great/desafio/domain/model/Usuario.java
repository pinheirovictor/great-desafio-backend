package com.great.desafio.domain.model;

import com.great.desafio.domain.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Usuario {

    @NotNull(groups = ValidationGroups.UserId.class)
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Size(max = 11)
    private String cpf;

    @NotBlank
    @Size(max = 8)
    private String rg;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NotBlank
    @Column(name = "mother_name")
    private String motherName;

    @CreationTimestamp
    @Column(name = "registration_date")
    private OffsetDateTime registrationDate;


}
