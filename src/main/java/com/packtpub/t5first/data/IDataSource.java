package com.packtpub.t5first.data;

/**
 * Created by Kalantaev Alexandr on 23.06.2016.
 */

import com.packtpub.t5first.model.Celebrity;

import java.util.List;
public interface IDataSource
{
    public List<Celebrity> getAllCelebrities();
    public Celebrity getCelebrityById(long id);
    public void addCelebrity(Celebrity c);
    List<Celebrity> getRange(int indexFrom, int indexTo);
}