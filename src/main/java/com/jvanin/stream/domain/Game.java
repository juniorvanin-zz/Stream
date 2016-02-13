package com.jvanin.stream.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;


@AllArgsConstructor
@EqualsAndHashCode (exclude = "id")
@Entity
@Table(name="game")
public class Game {

    private Long id;
    private String title;
    private int year;
}
