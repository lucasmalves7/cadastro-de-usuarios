package com.lucasmalves.caduser.infraestructure.entitys;

import jakarta.persistence.*;
import lombok.*;

//Getters e Setter para obter parâmetros/informações de algum atributo
@Getter
@Setter
//Abaixo estão meus construtores para acessar minha Classe
@AllArgsConstructor
@NoArgsConstructor
//Builder será utilizado para fazer o update
@Builder
//Table para indicar que isso aqui é uma tabela
@Table(name = "usuario") //nome da tabela
//
@Entity
public class Usuario {

    @Id //Identificador único da tabela.
    //Generate Value irá gerar o ID automaticamente
    //assim que bater no repository
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //Definindo as colunas do banco de dados:
    @Column(name="email", unique = true) //e-mail precisa ser único (unique)
    private String email;

    @Column(name="nome")
    private String nome;

}
