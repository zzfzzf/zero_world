package com.zzy.controller;

import com.alibaba.fastjson.JSONObject;
import com.zzy.base.BaseController;
import com.zzy.base.BaseDefine;
import com.zzy.common.base.ResultValue;
import com.zzy.domain.base.GItems;
import com.zzy.domain.base.GRole;
import com.zzy.domain.base.ZUser;
import com.zzy.utils.UUIDUtils;
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
public class ItemController extends BaseController {

	@ApiOperation(value = "获取列表", notes = "获取item列表")
	@RequestMapping(value = { "/item" }, method = RequestMethod.GET)
	public JSONObject listTemp() {
		return ResultValue.success(itemService.list());
	}
 
	@ApiOperation(value = "创建item", notes = "根据对象创建item")
	@RequestMapping(value = "/item", method = RequestMethod.POST)
	public JSONObject postTemp(@RequestBody GItems obj) {
		return Objects.isNull(obj)?ResultValue.requireNonNull():ResultValue.success(itemService.add(obj));
	}

	@ApiOperation(value = "获取item详细信息", notes = "根据url的id来获取详细信息")
	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
	public JSONObject getTemp(@PathVariable String id) {
		return Objects.isNull(id)?ResultValue.requireNonNull():ResultValue.success(itemService.get(id));
	}

	@ApiOperation(value = "更新详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
	@RequestMapping(value = "/item", method = RequestMethod.PUT)
	public JSONObject putTemp(@RequestBody GItems obj) {
		return Objects.isNull(obj)?ResultValue.requireNonNull():ResultValue.success(itemService.update(obj));
	}

	@ApiOperation(value = "删除", notes = "根据url的id来指定删除对象")
	@RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
	public JSONObject deleteTemp(@PathVariable String id) {
		return Objects.isNull(id)?ResultValue.requireNonNull():ResultValue.success(itemService.update(new GItems(id).setStatus(BaseDefine.DELETE_CODE)));
	}

}