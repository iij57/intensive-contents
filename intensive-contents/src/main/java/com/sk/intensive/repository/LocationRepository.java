package com.sk.intensive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sk.intensive.entity.LocationEntity;

public interface LocationRepository extends CrudRepository<LocationEntity, String> {
	
	LocationEntity findByAddrId(long addrId);
	
    @Query(value = "SELECT ADDRID, JUSO, WGS84_X, WGS84_Y FROM LOCATION WHERE WGS84_X = :wgs84X AND WGS84_Y = :wgs84Y", nativeQuery=true)
    List<Object[]> findLocationsByNativeByGeo(@Param("wgs84X") String wgs84X, @Param("wgs84Y") String wgs84Y);
	
	List<LocationEntity> findAll();
}