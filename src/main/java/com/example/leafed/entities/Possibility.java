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
    private Long possibilityId;

    public void setPossibilityId(Long possibilityId) {
        this.possibilityId = possibilityId;
    }

    @Id
    public Long getPossibilityId() {
        return possibilityId;
    }


    @ManyToOne
    private Member member;
    @ManyToOne
    private Publication publication;
}
