package com.zzy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zzy.service.common.AreaService;
import com.zzy.service.common.BagService;
import com.zzy.service.common.BuffService;
import com.zzy.service.common.BuildService;
import com.zzy.service.common.EquipService;
import com.zzy.service.common.GeniusService;
import com.zzy.service.common.ImageService;
import com.zzy.service.common.ItemService;
import com.zzy.service.common.LandService;
import com.zzy.service.common.MonsterService;
import com.zzy.service.common.NpcService;
import com.zzy.service.common.PositionService;
import com.zzy.service.common.PowerService;
import com.zzy.service.common.RaceService;
import com.zzy.service.common.RedisService;
import com.zzy.service.common.RoleService;
import com.zzy.service.common.SkillService;
import com.zzy.service.common.UserService;
import com.zzy.service.common.VocationService;
import com.zzy.service.common.VoiceService;
import com.zzy.service.cross.BagItemService;
import com.zzy.service.cross.EquipItemService;
import com.zzy.service.cross.PositionPowerService;
import com.zzy.service.cross.RaceGeniusService;
import com.zzy.service.cross.RoleBuffService;
import com.zzy.service.cross.RoleFriendService;
import com.zzy.service.cross.RoleSkillService;
import com.zzy.service.cross.SkillBuffService;
import com.zzy.service.cross.UserPositionService;
import com.zzy.service.cross.VocationSkillService;

/**
 * @author zeus @RestController==@Controller+@ResponseBody(默认自动返回JSON数据，作为一个接口)
 */
// 切记一定要标注method=xxxx 否则swagger将会为每个方法包括头部信息创建多个api
@RequestMapping(value = "/zeus")
@RestController
public class BaseController {
	// redis服务类
	@Autowired
	public RedisService redisService;
	@Autowired
	public RoleService roleService;
	@Autowired
	public AreaService areaService;
	@Autowired
	public BagService bagService;
	@Autowired
	public BuffService buffService;
	@Autowired
	public BuildService buildService;
	@Autowired
	public EquipService equipService;
	@Autowired
	public GeniusService geniusService;
	@Autowired
	public ImageService imageService;
	@Autowired
	public ItemService itemService;
	@Autowired
	public LandService landService;
	@Autowired
	public MonsterService monsterService;
	@Autowired
	public NpcService npcService;
	@Autowired
	public PositionService positionService;
	@Autowired
	public PowerService powerService;
	@Autowired
	public RaceService raceService;
	@Autowired
	public SkillService skillService;
	@Autowired
	public UserService userService;
	@Autowired
	public VocationService vocationService;
	@Autowired
	public VoiceService voiceService;
	@Autowired
	public BagItemService bagItemService;
	@Autowired
	public EquipItemService equipItemService;
	@Autowired
	public PositionPowerService positionPowerService;
	@Autowired
	public RaceGeniusService raceGeniusService;
	@Autowired
	public RoleBuffService roleBuffService;
	@Autowired
	public RoleFriendService roleFriendService;
	@Autowired
	public RoleSkillService roleSkillService;
	@Autowired
	public UserPositionService userPositionService;
	@Autowired
	public VocationSkillService vocationSkillService;
	@Autowired
	public SkillBuffService skillBuffService;
}