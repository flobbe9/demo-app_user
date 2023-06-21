package com.example.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.models.AbstractEntity;
import com.example.user.repositories.Dao;


@Service
public abstract class AbstractService <E extends AbstractEntity> {
    
    @Autowired
    private Dao<E> dao;


    public Dao<E> getDao() {

        return this.dao;
    }
}