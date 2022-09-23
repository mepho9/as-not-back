package com.example.leafed.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Possibility {

    @Id
    private Long possibilityId;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Publication publication;
}
