package com.zzy.controller;

import com.alibaba.fastjson.JSONObject;
import com.zzy.base.BaseController;
import com.zzy.base.BaseDefine;
import com.zzy.common.base.ResultValue;
import com.zzy.domain.base.GMap;
import com.zzy.domain.base.GRole;
import com.zzy.domain.base.ZUser;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author Zeus
 * @version 1.1
 * @date：2016年6月30日
 * @decript:模板Controller
 */
// 切记一定要标注method=xxxx 否则swagger将会为每个方法包括头部信息创建多个api
@RestController
public class MapController extends BaseController {

	@ApiOperation(value = "获取map", notes = "获取map列表")
	@RequestMapping(value = { "/map" }, method = RequestMethod.GET)
	public JSONObject listTemp() {
		return ResultValue.success(mapService.list());
		
	}
 
	@ApiOperation(value = "创建map", notes = "根据map对象创建用户")
	@RequestMapping(value = "/map", method = RequestMethod.POST)
	public JSONObject postTemp(@RequestBody GMap map) {
		if(Objects.isNull(map)){
			return ResultValue.requireNonNull();
		}
		mapService.add(map);
		return ResultValue.success();
	}

	@ApiOperation(value = "获取map详细信息", notes = "根据url的id来获取详细信息")
	@RequestMapping(value = "/map/{id}", method = RequestMethod.GET)
	public JSONObject getTemp(@PathVariable String id) {
		if(Objects.isNull(id)){
			return ResultValue.requireNonNull();
		}
		return ResultValue.success(mapService.get(id));
	}

	@ApiOperation(value = "更新map详细信息", notes = "根据url的id来指定更新对象，并根据传过来的map信息来更新用户详细信息")
	@RequestMapping(value = "/map", method = RequestMethod.PUT)
	public JSONObject putTemp(@RequestBody GMap map) {
		if(Objects.isNull(map)){
			return ResultValue.requireNonNull();
		}
		mapService.update(map);
		return ResultValue.success();
	}

	@ApiOperation(value = "删除map", notes = "根据url的id来指定删除对象")
	@RequestMapping(value = "/map/{id}", method = RequestMethod.DELETE)
	public JSONObject deleteTemp(@PathVariable String id) {
		if(Objects.isNull(id)){
			return ResultValue.requireNonNull();
		}
		GMap map =new GMap(id);
		map.setStatus(BaseDefine.DELETE_CODE);
		mapService.update(map);
		return ResultValue.success();
	}

}