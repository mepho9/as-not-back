package com.example.leafed.mapper;


import com.example.leafed.dto.PossibilityDTO;
import com.example.leafed.entities.Possibility;
import com.example.leafed.form.possibility.InsertPossibility;
import com.example.leafed.form.possibility.UpdatePossibility;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PossibilityMapper {

    @Transactional
    public PossibilityDTO toDto(Possibility possibility){
        if(possibility==null){
            return null;
        }

        return PossibilityDTO.builder()
                .possibilityId(possibility.getPossibilityId())
                .possibilityText(possibility.getPossibilityText())
                .build();
    }

    public Possibility toEntity(InsertPossibility toInsert){
        if(toInsert==null){
            return null;
        }
        else{
            Possibility possibility = new Possibility();

            possibility.setPossibilityText(toInsert.getPossibilityText());

            return possibility;
        }
    }

    public Possibility toEntityU(UpdatePossibility toUpdate){
        if(toUpdate==null){
            return null;
        }

        Possibility possibility = new Possibility();

        possibility.setPossibilityText(toUpdate.getPossibilityText());

        return possibility;

    }

}
