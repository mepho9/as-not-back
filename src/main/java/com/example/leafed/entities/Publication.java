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
@AllArgsConstructor
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long publicationId;

    @Column(nullable = false)
    private String publicationText;


    @ManyToOne
    private Member member;

    @OneToMany(mappedBy = "publication")
    private List<Possibility> possibilities;

    @OneToMany(mappedBy = "publication")
    private List<Comment> comments;

}
