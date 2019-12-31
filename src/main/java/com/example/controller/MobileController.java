package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Mobile;
import com.example.repository.MobileRepository;
import com.example.service.MobileService;
import com.example.service.impl.ResourceNotFoundException;

@RestController
@RequestMapping(value = "mobile/")
public class MobileController {

	@Autowired
	MobileService mobileService;
	
	@Autowired
	MobileRepository mobileRepo;
	

	@PostMapping(value = "save")
	public Mobile saveMobile(@RequestBody Mobile mobile) {
		return mobileService.saveMobile(mobile);
	}

	@PutMapping(value = "update")
	public String updateMobile(@RequestBody Mobile mobile) {
		mobileService.updateMobile(mobile);
		return "Updated Successfully";
	}

	@DeleteMapping(value = "delete")
	public String deleteMobile(@RequestParam("mobileId") Integer mobileId) {
		mobileService.deleteMobile(mobileId);
		return "deleted successfully";
	}

	@GetMapping(value = "getby")
	public Optional<Mobile> getById(@RequestParam("mobileId") Integer mobileId) {
		return mobileService.getMobile(mobileId);

	}

	@GetMapping(value = "getAllMobiles")
	public List<Mobile> getallMobiles() {
		return mobileService.getAllMobiles();
	}
	
	
	 @PutMapping("update1")
	    public Mobile updateMobile1( @RequestBody Mobile mobile) {
	        return mobileService.getMobile(mobile.getId()).map(mob -> {
	          mob.setCompanyName(mobile.getCompanyName());
	          mob.setModel(mobile.getModel());
	            return mobileService.saveMobile(mobile);
	        }).orElseThrow(() -> new ResourceNotFoundException("MobileId " + mobile.getId() + " not found"));
	    }

}
