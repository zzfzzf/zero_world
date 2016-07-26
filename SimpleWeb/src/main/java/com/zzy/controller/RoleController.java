package com.zzy.controller;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.zzy.base.ResultValue;
import com.zzy.base.UUIDUtils;
import com.zzy.domain.base.GBuff;
import com.zzy.domain.base.GLand;
import com.zzy.domain.base.GRole;
import com.zzy.domain.base.GSkill;

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
		if (Objects.isNull(user)) {
			return ResultValue.requireNonNull();
		}
		GRole role=roleService.findByName(user);
		return ResultValue.success(role);
	}
	
	@ApiOperation(value = "获取role", notes = "")
	@RequestMapping(value = { "/role/{id}" }, method = RequestMethod.GET)
	public JSONObject getRole(@PathVariable String id) throws SQLException {
		if (Objects.isNull(id)) {
			return ResultValue.requireNonNull();
		}
		GRole role=roleService.get(id);
		return ResultValue.success(role);
	}

	@ApiOperation(value = "删除角色", notes = "")
	@RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
	public JSONObject deleteRole(@PathVariable String id) {
		if (Objects.isNull(id)) {
			return ResultValue.requireNonNull();
		}
		GRole role = roleService.get(id);
		role.setStatus(10);
		roleService.update(role);
		return ResultValue.success();
	}

	@ApiOperation(value = "修改角色", notes = "")
	@RequestMapping(value = "/role", method = RequestMethod.PUT)
	public JSONObject updateRole(@RequestBody GRole role) {
		if (Objects.isNull(role)) {
			return ResultValue.requireNonNull();
		}
			roleService.update(role);
			return ResultValue.success(); 
	}

	@ApiOperation(value = "获取角色列表", notes = "")
	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public JSONObject listRole() {
		List<GRole> list = roleService.findByStatusNot(10);
		return ResultValue.success(list);
	}

	@ApiOperation(value = "新增角色", notes = "")
	@RequestMapping(value = "/role", method = RequestMethod.POST)
	public JSONObject addRole(@RequestBody GRole role) {
		if (Objects.isNull(role)) {
			return ResultValue.requireNonNull();
		}
		role.setId(UUIDUtils.uuid32());
		roleService.add(role);
		return ResultValue.success();
	}
}
