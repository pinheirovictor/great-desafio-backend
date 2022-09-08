package com.great.desafio.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Getter
@Setter
public class UsuarioModel {

    private Long id;
    private String name;
    private String cpf;
    private String rg;
    private LocalDate birthDate;
    private String motherName;
    private OffsetDateTime registrationDate;


}
