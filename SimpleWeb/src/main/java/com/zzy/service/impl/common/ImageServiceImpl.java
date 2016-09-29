package com.zzy.service.impl.common;

import com.zzy.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.zzy.domain.base.GImage;
import com.zzy.service.common.ImageService;
/**
* @author Zeus
* @version 1.1
* @createTime：2016年7月12日 
* @decript:
*/
@Service
public class ImageServiceImpl extends BaseServiceImp<GImage> implements ImageService{
	@Autowired
	public ImageServiceImpl(CrudRepository<GImage, String> crudRepository) {
		super(crudRepository);
	}
}
