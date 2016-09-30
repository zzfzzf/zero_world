package com.zzy.controller;

import java.util.Objects;

import com.zzy.base.BaseController;
import com.zzy.base.BaseDefine;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.zzy.utils.UUIDUtils;
import com.zzy.common.base.ResultValue;
import com.zzy.domain.base.ZUser;

import io.swagger.annotations.ApiOperation;

/**
 * @author Zeus
 * @version 1.1
 * @createTime 2016年6月30日 
 * @decript 模板Controller
 */
// 切记一定要标注method=xxxx 否则swagger将会为每个方法包括头部信息创建多个api
@RestController
public class UserController extends BaseController {
  
	@ApiOperation(value = "获取user", notes = "获取user列表")
	@RequestMapping(value = { "/user" }, method = RequestMethod.GET)
	public JSONObject listUser() {
		return ResultValue.success(userService.findByStatusNot(10));
	}

	@ApiOperation(value = "根据username获取user", notes = "根据username获取user")
	@RequestMapping(value = { "/user/username/{username}" }, method = RequestMethod.GET)
	public JSONObject getUserByUsername(@PathVariable String username) {
		return ResultValue.success(userService.findByUsername(username));
	}
	
	@ApiOperation(value = "登录验证", notes = "用户登录验证")
	@RequestMapping(value = { "/user/login" }, method = RequestMethod.POST)
	public JSONObject login(@RequestBody ZUser user) {
		return userService.login(user)?ResultValue.success():ResultValue.fail(ResultValue.LOGIN_FAIL, "登录失败");
	}
	
	@ApiOperation(value = "创建user", notes = "根据User对象创建用户")
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public JSONObject postUser(@RequestBody ZUser user) {
		return Objects.isNull(user)?ResultValue.requireNonNull():ResultValue.success(userService.add(user));
	}

	@ApiOperation(value = "获取user详细信息", notes = "根据url的id来获取详细信息")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public JSONObject getUser(@PathVariable String id) {
		return Objects.isNull(id)?ResultValue.requireNonNull():ResultValue.success( userService.get(id));
	}

	@ApiOperation(value = "更新user详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public JSONObject putUser(@RequestBody ZUser user) {
		return Objects.isNull(user)?ResultValue.requireNonNull():ResultValue.success(userService.update(user));
	}

	@ApiOperation(value = "删除user", notes = "根据url的id来指定删除对象")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public JSONObject deleteUser(@PathVariable String id) {
		return Objects.isNull(id)?ResultValue.requireNonNull():ResultValue.success(userService.update(new ZUser(id).setStatus(BaseDefine.DELETE_CODE)));
	}

}