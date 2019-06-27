package com.sk.intensive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sk.intensive.entity.ContentEntity;

public interface ContentRepository extends CrudRepository<ContentEntity, String> {
	
	ContentEntity findByContentId(long contentId);
	
	List<ContentEntity> findByAddrId(String addrId);
	
	List<ContentEntity> findAll();
}