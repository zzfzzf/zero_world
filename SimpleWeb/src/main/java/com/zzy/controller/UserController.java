package com.zzy.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.zzy.base.UUIDUtils;
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
		List<ZUser> userList = userService.findByStatusNot(10);
		return ResultValue.success(userList); 
	}

	@ApiOperation(value = "根据username获取user", notes = "根据username获取user")
	@RequestMapping(value = { "/user/username/{username}" }, method = RequestMethod.GET)
	public JSONObject getUserByUsername(@PathVariable String username) {
		ZUser user=userService.findByUsername(username);
		return ResultValue.success(user);
	}
	
	@ApiOperation(value = "登录验证", notes = "用户登录验证")
	@RequestMapping(value = { "/user/login" }, method = RequestMethod.POST)
	public JSONObject login(@RequestBody ZUser user) {
		JSONObject result = ResultValue.success();
		if(userService.login(user)){ 
			result = ResultValue.fail(ResultValue.LOGIN_FAIL, "登录失败"); 
		} 
		return result;
	}
	
	@ApiOperation(value = "创建user", notes = "根据User对象创建用户")
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public JSONObject postUser(@RequestBody ZUser user) {
		if (Objects.isNull(user)) {
			return ResultValue.requireNonNull();
		}
		user.setId(UUIDUtils.uuid32());
		userService.add(user);
		return ResultValue.success();
	}

	@ApiOperation(value = "获取user详细信息", notes = "根据url的id来获取详细信息")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public JSONObject getUser(@PathVariable String id) {
		if (Objects.isNull(id)) {
			return ResultValue.requireNonNull();
		}
		ZUser user = userService.get(id);
		return ResultValue.success(user);
	}

	@ApiOperation(value = "更新user详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public JSONObject putUser(@RequestBody ZUser user) {
		if (Objects.isNull(user)) {
			return ResultValue.requireNonNull();
		}
		userService.update(user);
		return ResultValue.success();
	}

	@ApiOperation(value = "删除user", notes = "根据url的id来指定删除对象")
	@RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
	public JSONObject deleteUser(@PathVariable String id) {
		if(Objects.isNull(id)){
			return ResultValue.requireNonNull();
		}
		ZUser user = new ZUser(); 
		user.setStatus(10);
		user.setId(id);
		userService.update(user);
		return ResultValue.success();
	}

}