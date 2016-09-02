package com.zzy.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.ResultValue;
import com.zzy.domain.base.GArea;

import io.swagger.annotations.ApiOperation;

/**
 * @author Zeus
 * @version 1.1
 * @date：2016年6月30日
 * @decript:模板Controller
 */
// 切记一定要标注method=xxxx 否则swagger将会为每个方法包括头部信息创建多个api
@RestController
public class AreaController extends BaseController {

	@ApiOperation(value = "获取area", notes = "获取area列表")
	@RequestMapping(value = { "/area" }, method = RequestMethod.GET)
	public JSONObject listArea() {  
		List<GArea> areaList = areaService.list();
		return ResultValue.success(areaList);
		
	}
 
	@ApiOperation(value = "创建area", notes = "根据Area对象创建用户")
	@RequestMapping(value = "/area", method = RequestMethod.POST)
	public JSONObject postArea(@RequestBody GArea area) {
		if(Objects.isNull(area)){
			return ResultValue.requireNonNull();
		}
		areaService.add(area);
		return ResultValue.success();
	}

	@ApiOperation(value = "获取area详细信息", notes = "根据url的id来获取area详细信息")
	@RequestMapping(value = "/area/{id}", method = RequestMethod.GET)
	public JSONObject getArea(@PathVariable String id) {
		if(Objects.isNull(id)){
			return ResultValue.requireNonNull();
		}
		GArea area = areaService.get(id);
		return ResultValue.success(area);
	}

	@ApiOperation(value = "更新area详细信息", notes = "根据url的id来指定更新对象，并根据传过来的area信息来更新用户详细信息")
	@RequestMapping(value = "/area", method = RequestMethod.PUT)
	public JSONObject putArea(@RequestBody GArea area) {
		if(Objects.isNull(area)){
			return ResultValue.requireNonNull();
		}
		areaService.update(area);
		return ResultValue.success();
	}

	@ApiOperation(value = "删除area", notes = "根据url的id来指定删除对象")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public JSONObject deleteArea(@PathVariable String id) {
		if(Objects.isNull(id)){
			return ResultValue.requireNonNull();
		}   
		GArea area = areaService.get(id);
		area.setStatus(10);
		areaService.update(area);
		return ResultValue.success();
	}

}