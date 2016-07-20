package com.zzy.repository.cross;
import org.springframework.data.repository.CrudRepository;

import com.zzy.domain.cross.GBagItem;

/** 
* @author zero
* @version 1.0.0
* @date:2016年4月1日
* @description:
*/
public interface BagItemRepository extends CrudRepository<GBagItem, String>{
}
