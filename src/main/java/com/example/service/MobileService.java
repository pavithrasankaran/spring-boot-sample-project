package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entity.Mobile;
@Service
public interface MobileService {

	public Mobile saveMobile(Mobile mob);

	public void updateMobile(Mobile mob);

	public Optional<Mobile> getMobile(Integer mobId);

	public List<Mobile> getAllMobiles();

	public void deleteMobile(Integer mobId);

}
