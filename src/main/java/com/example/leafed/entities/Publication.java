package com.example.leafed.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publicationId;

    @Column(nullable = false)
    private String publicationText;


    @ManyToOne
    private Member memberPublication;

    @OneToMany(mappedBy = "publicationPoss")
    private List<Possibility> possibilities;

    @OneToMany(mappedBy = "publicationCom")
    private List<Comment> comments;

}
