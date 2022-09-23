package com.example.leafed.entities;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String pseudo;

    private String country;

    private LocalDate birthDate;

    @OneToMany(mappedBy = "memberPublication")
    private List<Publication> publications;

    @OneToMany(mappedBy = "memberCom")
    private List<Comment> memberComments;

//    @OneToOne
//    private Honor Honor;

}
