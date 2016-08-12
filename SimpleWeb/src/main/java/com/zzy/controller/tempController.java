package com.zzy.controller;

import java.util.Objects;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.zzy.common.base.ResultValue;
import com.zzy.domain.base.GRole;
import com.zzy.domain.base.ZUser;

import io.swagger.annotations.ApiOperation;

/**
 * @author Zeus
 * @version 1.1
 * @date：2016年6月30日
 * @decript:模板Controller
 */
// 切记一定要标注method=xxxx 否则swagger将会为每个方法包括头部信息创建多个api
@RestController
public class tempController extends BaseController {

	@ApiOperation(value = "获取", notes = "获取列表")
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public JSONObject listTemp() {
		return ResultValue.success();
		
	}
 
	@ApiOperation(value = "创建", notes = "根据对象创建用户")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public JSONObject postTemp(@RequestBody ZUser user) {
		if(Objects.isNull(user)){
			return ResultValue.requireNonNull();
		}
		return ResultValue.success();
	}

	@ApiOperation(value = "获取详细信息", notes = "根据url的id来获取详细信息")
	@RequestMapping(value = "//{id}", method = RequestMethod.GET)
	public JSONObject getTemp(@PathVariable String id) {
		if(Objects.isNull(id)){
			return ResultValue.requireNonNull();
		}
		return ResultValue.success();
	}

	@ApiOperation(value = "更新详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public JSONObject putTemp(@RequestBody ZUser user) {
		if(Objects.isNull(user)){
			return ResultValue.requireNonNull();
		}
		return ResultValue.success();
	}

	@ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public JSONObject deleteTemp(@PathVariable String id) {
		if(Objects.isNull(id)){
			return ResultValue.requireNonNull();
		}
		GRole role = roleService.get(id);
		role.setStatus(10);
		roleService.update(role);
		return ResultValue.success();
	}

}