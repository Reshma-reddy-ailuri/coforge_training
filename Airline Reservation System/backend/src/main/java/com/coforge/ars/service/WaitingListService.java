package com.coforge.ars.service;

import java.util.List;
import java.util.Optional;

import com.coforge.ars.model.WaitingList;

public interface WaitingListService {

	boolean saveWaitingList(WaitingList waitingList);

	boolean updateWaitingList(Integer waitingId, WaitingList waitingList);

	boolean deleteWaitingListById(Integer waitingId);

	Optional<WaitingList> findByWaitingId(Integer waitingId);

	List<WaitingList> findAllWaitingLists();

}