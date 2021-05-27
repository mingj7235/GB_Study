package com.koreait.domain;

import java.util.List;

import lombok.Data;

@Data
public class AllFileDTO {
	List<AttachFileDTO> succeedList;
	List<AttachFileDTO> failureList;
}
