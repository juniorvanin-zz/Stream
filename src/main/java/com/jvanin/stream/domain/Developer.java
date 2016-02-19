package com.jvanin.stream.domain;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
@Getter
@Setter
@Entity
@Table(name="developer", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Developer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
}
