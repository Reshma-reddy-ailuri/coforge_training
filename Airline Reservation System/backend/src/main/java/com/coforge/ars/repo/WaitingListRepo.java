package com.coforge.ars.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.ars.model.WaitingList;

@Repository
public interface WaitingListRepo extends CrudRepository<WaitingList, Integer>{

}