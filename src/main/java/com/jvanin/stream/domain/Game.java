package com.jvanin.stream.domain;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (exclude = "id")
@Getter
@Setter
@Entity
@Table(name="game", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Game {

    public Game(String title, int year){
        this.title = title;
        this.year = year;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int year;

    @OneToOne
    @JoinColumn(name = "developer")
    private Developer developer;
}
