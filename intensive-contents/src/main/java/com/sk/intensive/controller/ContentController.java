package com.sk.intensive.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sk.intensive.dto.ContentDTO;
import com.sk.intensive.dto.LocationDTO;
import com.sk.intensive.entity.ContentEntity;
import com.sk.intensive.entity.LocationEntity;
import com.sk.intensive.service.ContentService;
import com.sk.intensive.service.LocationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ContentController {
    private static final Logger logger = LoggerFactory.getLogger(ContentController.class);
    private LocationService locationService;
    private ContentService contentService;
    
//    Location CMD Start
    @PostMapping("/v1/locations")
	public void create(@RequestBody LocationDTO location) {
    	logger.info("Call API LocationController.create");
		locationService.create(location);
	}
    
    @PutMapping("/v1/locations")
	public void update(@RequestBody LocationEntity location) {
    	logger.info("Call API UserController.update");
		locationService.update(location);;
	}
    
    @GetMapping("/v1/locations")
	public List<LocationEntity> getLocations(){
    	logger.info("Call API LocationController.getLocations");
		return locationService.getLocations();
	}
    
    @GetMapping("/v1/locations/{geo}/")
    public List<LocationEntity> getLocationsByGeo(@PathVariable("geo") Object[] geo) throws Exception {
        logger.info("CALL API LocationInfoController.getLocationsByGeo {geo X: " + geo[0].toString() + ", geo Y: "+ geo[1].toString() + "}");
        return locationService.getLocationsByGeo(geo);
    }
    
    
//    Content CMD Start
    @PostMapping("/v1/contents")
	public void create(@RequestBody ContentDTO content) {
    	logger.info("Call API ContentController.create");
    	contentService.create(content);
	}
    
    @PutMapping("/v1/contents")
	public void update(@RequestBody ContentEntity content) {
    	logger.info("Call API ContentController.update");
    	contentService.update(content);
	}
    
    @GetMapping("/v1/contents")
	public List<ContentEntity> getContents(){
    	logger.info("Call API ContentController.update");
		return contentService.getContents();
	}
    
    @GetMapping("/v1/contents/{addrId}")
	public List<ContentEntity> getContentsByAddrId(@PathVariable("addrId") String addrId){
    	logger.info("Call API ContentController.getContentsByAddrId");
		return contentService.getContentsByAddrId(addrId);
	}
    
}