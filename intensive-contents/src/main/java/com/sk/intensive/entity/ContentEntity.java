package com.sk.intensive.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CONTENT")
@Data
public class ContentEntity {
	@Id
    @GeneratedValue
    @Column(name = "CONTENT_ID",nullable = false, updatable = false)
    private long contentId;
	
	@Column(name = "ADDR_ID")
    private String addrId;
	
	@Column(name = "CHAT_ID")
    private String chatId;

    @Column(name = "SHARE_LV")
    private String shareLv;
    
    @Column(name = "CONTENT_TYPE")
    private String contentType;
    
    @Column(name = "CONTENT_TITLE")
    private String contentTitle;

    @Column(name = "CONTENT_BODY")
    private String contentBody;
    
    public long getContentId() {
        return contentId;
    }
    
}