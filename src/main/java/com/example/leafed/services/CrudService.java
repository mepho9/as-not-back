package com.example.leafed.services;

import java.util.List;

public interface CrudService<T, TID, TIFORM, TUFORM> {

    // create
    T create(TIFORM toInsert);

    T update(TID id, TUFORM toUpdate);

    T getOne(TID id);
    List<T> getAll();

    T delete(TID id);

}
