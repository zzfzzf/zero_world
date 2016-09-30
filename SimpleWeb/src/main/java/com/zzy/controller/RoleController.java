package com.zzy.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import com.zzy.base.BaseController;
import com.zzy.base.BaseDefine;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.zzy.utils.UUIDUtils;
import com.zzy.common.base.ResultValue;
import com.zzy.domain.base.GRole;

import io.swagger.annotations.ApiOperation;

/**
 * @author Zeus
 * @version 1.1
 * @createTime：2016年6月30日
 * @decript:角色控制器 
 */
@RestController
public class RoleController extends BaseController {
	private static Logger log = Logger.getLogger(RoleController.class);
	
	@ApiOperation(value = "根据user获取role", notes = "")
	@RequestMapping(value = { "/role/user/{user}" }, method = RequestMethod.GET)
	public JSONObject getRoleByUser(@PathVariable String user) throws SQLException {
		return Objects.isNull(user)?ResultValue.requireNonNull():ResultValue.success(roleService.findByName(user));
	}
	  
	@ApiOperation(value = "根据area获取role", notes = "")
	@RequestMapping(value = { "/role/area/{areaId}" }, method = RequestMethod.GET)
	public JSONObject getRoleByAreaId(@PathVariable String areaId) throws SQLException {
		return Objects.isNull(areaId)?ResultValue.requireNonNull():ResultValue.success(roleService.findByAreaId(areaId));
	} 
	
	@ApiOperation(value = "获取role", notes = "根据id获取role详情")
	@RequestMapping(value = { "/role/{id}" }, method = RequestMethod.GET)
	public JSONObject getRole(@PathVariable String id) throws SQLException {
		return Objects.isNull(id)?ResultValue.requireNonNull():ResultValue.success(roleService.get(id));
	}

	@ApiOperation(value = "删除角色", notes = "根据id删除(假删除)role")
	@RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
	public JSONObject deleteRole(@PathVariable String id) {
		return Objects.isNull(id)?ResultValue.requireNonNull():ResultValue.success(roleService.update(new GRole(id).setStatus(BaseDefine.DELETE_CODE)));
	}

	@ApiOperation(value = "修改角色", notes = "")
	@RequestMapping(value = "/role", method = RequestMethod.PUT)
	public JSONObject updateRole(@RequestBody GRole role) {
		return Objects.isNull(role)?ResultValue.requireNonNull():ResultValue.success(roleService.update(role));
	}

	@ApiOperation(value = "获取角色列表", notes = "")
	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public JSONObject listRole() {
		return ResultValue.success(roleService.findByStatusNot(BaseDefine.DELETE_CODE));
	}

	@ApiOperation(value = "新增角色", notes = "")
	@RequestMapping(value = "/role", method = RequestMethod.POST)
	public JSONObject addRole(@RequestBody GRole role) {
		return Objects.isNull(role)?ResultValue.requireNonNull():ResultValue.success(roleService.add(role));
	}
}
