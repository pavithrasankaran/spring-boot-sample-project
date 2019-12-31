package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Mobile;
import com.example.repository.MobileRepository;
import com.example.service.MobileService;

@Service
@Transactional
public class MobileServiceImpl implements MobileService {

	@Autowired
	MobileRepository mobileRepository;

	@Override
	public Mobile saveMobile(Mobile mob) {
		return mobileRepository.save(mob);
	}

	@Override
	public void updateMobile(Mobile mob) {
		Optional<Mobile> mobile = mobileRepository.findById(mob.getId());
		if (mobile.isPresent()) {
			Mobile newMobile = mobile.get();
			newMobile = mob;
			mobileRepository.save(newMobile);
		}
	}

	@Override
	public Optional<Mobile> getMobile(Integer mobId) {
		return mobileRepository.findById(mobId);
	}

	@Override
	public List<Mobile> getAllMobiles() {
		return mobileRepository.findAll();
	}

	@Override
	public void deleteMobile(Integer mobId) {
		Optional<Mobile> mobile = mobileRepository.findById(mobId);
		if (mobile.isPresent()) {
			mobileRepository.deleteById(mobId);
		}

	}

}
