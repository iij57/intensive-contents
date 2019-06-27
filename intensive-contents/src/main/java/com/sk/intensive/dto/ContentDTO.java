package com.sk.intensive.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
public class ContentDTO {
	private String contentId;
    private String addrId;
    private String chatId;
    private String shareLv;
    private String contentType;
    private String contentTitle;
    private String contentBody;
}