package com.sk.intensive.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sk.intensive.dto.ContentDTO;
import com.sk.intensive.entity.ContentEntity;
import com.sk.intensive.repository.ContentRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ContentService {
    private static final Logger logger = LoggerFactory.getLogger(ContentService.class);

    private ContentRepository contentRepository;

    public void create(ContentDTO content) {
		
		ContentEntity contentEntity = new ContentEntity();
		
		contentEntity.setAddrId(content.getAddrId());
		contentEntity.setChatId(content.getChatId());
		contentEntity.setShareLv(content.getShareLv());
		contentEntity.setContentType(content.getContentType());
		contentEntity.setContentTitle(content.getContentTitle());
		contentEntity.setContentBody(content.getContentBody());
		
		contentRepository.save(contentEntity);
	}
    
    public void update(ContentEntity content) {
		
    	ContentEntity contentEntity = contentRepository.findByContentId(content.getContentId());
		
    	contentEntity.setAddrId(content.getAddrId());
		contentEntity.setChatId(content.getChatId());
		contentEntity.setShareLv(content.getShareLv());
		contentEntity.setContentType(content.getContentType());
		contentEntity.setContentTitle(content.getContentTitle());
		contentEntity.setContentBody(content.getContentBody());
		
		contentRepository.save(contentEntity);
	}
    
    public List<ContentEntity> getContents() {
		
    	logger.info("get All Content");
		
		return contentRepository.findAll();
		
	}
    
    public List<ContentEntity> getContentsByAddrId(String addrId) {
		
    	logger.info("getContentsByAddrId");
		
		return contentRepository.findByAddrId(addrId);
		
	}
    
}