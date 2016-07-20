package com.zzy.service.impl.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.GVoice;
import com.zzy.service.common.VoiceService;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class VoiceServiceImpl extends BaseServiceImp<GVoice> implements VoiceService{
	@Autowired
	public VoiceServiceImpl(CrudRepository<GVoice, String> crudRepository) {
		super(crudRepository);
	}
}
