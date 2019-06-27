package com.sk.intensive.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sk.intensive.GpsToAddress;
import com.sk.intensive.dto.LocationDTO;
import com.sk.intensive.entity.LocationEntity;
import com.sk.intensive.repository.LocationRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class LocationService {
    private static final Logger logger = LoggerFactory.getLogger(LocationService.class);

    private LocationRepository locationRepository;
    private GpsToAddress gpsToAddress;

    public void create(LocationDTO location) {
		
		LocationEntity locationEntity = new LocationEntity();
		
		locationEntity.setJuso(location.getJuso());
		locationEntity.setWgs84X(location.getWgs84X());
		locationEntity.setWgs84Y(location.getWgs84Y());
		
		locationRepository.save(locationEntity);
	}
    
    public void update(LocationEntity location) {
		
    	LocationEntity locationEntity = locationRepository.findByAddrId(location.getAddrId());
		
    	locationEntity.setJuso(location.getJuso());
    	locationEntity.setWgs84X(location.getWgs84X());
    	locationEntity.setWgs84Y(location.getWgs84Y());
		
		locationRepository.save(locationEntity);
	}
    
    public List<LocationEntity> getLocations() {
		
    	logger.info("get All Location");
		
		return locationRepository.findAll();
		
	}
	
    
    public List<LocationEntity> getLocationsByGeo(Object[] geo) throws Exception {
        final List<LocationEntity> returnValue = new ArrayList<>();
        List<Object[]> locationsNative = locationRepository.findLocationsByNativeByGeo(geo[0].toString(), geo[1].toString());
        
        if(locationsNative.isEmpty() == true) {
        	String juso = gpsToAddress.gpsToAddress(geo[0].toString(), geo[1].toString());
        	
        	LocationEntity locationEntity = new LocationEntity();
        	locationEntity.setJuso(juso);
    		locationEntity.setWgs84X(geo[0].toString());
    		locationEntity.setWgs84Y(geo[1].toString());
    		
    		locationRepository.save(locationEntity);
    		returnValue.add(locationEntity);
        }else {

        	for(Object[] locationNative : locationsNative) {
        		LocationEntity locationEntity = new LocationEntity();
        		locationEntity.setAddrId(Long.parseLong(locationNative[0].toString()));
        		locationEntity.setJuso(locationNative[1].toString());
        		locationEntity.setWgs84X(locationNative[2].toString());
        		locationEntity.setWgs84Y(locationNative[3].toString());
        		
        		returnValue.add(locationEntity);
        	}
        }
        
        return returnValue;
    }
    
}