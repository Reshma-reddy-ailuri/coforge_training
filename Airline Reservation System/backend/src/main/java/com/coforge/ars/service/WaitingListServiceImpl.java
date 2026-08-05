package com.coforge.ars.service;

import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.ars.exception.WaitingListNotFoundException;
import com.coforge.ars.model.WaitingList;
import com.coforge.ars.repo.WaitingListRepo;

@Service
public class WaitingListServiceImpl implements WaitingListService {

	private WaitingListRepo repo;
	private Environment environment;

	public WaitingListServiceImpl(WaitingListRepo repo, Environment environment) {
		this.repo = repo;
		this.environment = environment;
	}

	@Override
	public boolean saveWaitingList(WaitingList waitingList) {

		repo.save(waitingList);
		return true;
	}

	@Override
	public boolean updateWaitingList(Integer waitingId, WaitingList waitingList) {

		if (!repo.existsById(waitingId)) {
			throw new WaitingListNotFoundException(
					environment.getProperty("waiting.invalid.notfound"));
		}

		waitingList.setWaitingId(waitingId);

		repo.save(waitingList);
		return true;
	}

	@Override
	public boolean deleteWaitingListById(Integer waitingId) {

		if (!repo.existsById(waitingId)) {
			throw new WaitingListNotFoundException(
					environment.getProperty("waiting.invalid.notfound"));
		}

		repo.deleteById(waitingId);
		return true;
	}

	@Override
	public Optional<WaitingList> findByWaitingId(Integer waitingId) {

		if (!repo.existsById(waitingId)) {
			throw new WaitingListNotFoundException(
					environment.getProperty("waiting.invalid.notfound"));
		}

		return repo.findById(waitingId);
	}

	@Override
	public List<WaitingList> findAllWaitingLists() {

		return (List<WaitingList>) repo.findAll();
	}

}