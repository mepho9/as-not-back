package com.example.leafed.entities;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(nullable = false)
    private String pseudo;

    private String country;

    @Column(nullable = false)
    private LocalDate birthDate;


    @OneToMany(mappedBy = "member")
    private List<Publication> publications;

    @OneToMany(mappedBy = "memberCom")
    private List<Comment> comments;

    @OneToOne
    private Honor Honor;

}
