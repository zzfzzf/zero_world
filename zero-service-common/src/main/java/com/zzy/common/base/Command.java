/**
 * @author zeus
 * @date 2016年7月24日
 * @version 1.0
 * @describe:用一句话描述该类是干嘛的
 */
package com.zzy.common.base;

public interface Command {
    /**
     * token 令牌
     */
    String TOKEN = "token";
    /**
     * 登录
     */
    String LOGIN = "login";

    /**
     * 获取服务大区
     */
    String AREA = "area";
    /**
     * 获取大区下角色
     */
    String ROLE = "role";
    /**
     * 在线数量
     */
    String ONLINE_NUM = "onlineNum";
    /**
     * 离线
     */
    String OFFLINE = "offLine";

//	----------------------------角色指令------------------------
    /**
     * 角色移动
     */
    String MOVE = "move";
    /**
     * 攻击
     */
    String ATTACK = "attack";
    /**
     * 技能
     */
    String SKILL = "skill";
    /**
     * 骑乘
     */
    String RIDE = "ride";

    /**
     * 聊天
     */
    String CHAT = "chat";

    /**
     * 增加经验
     */
    String ADD_EXP = "addExp";
    /**
     * 减少经验
     */
    String REDUCE_EXP = "reduceExp";
    /**
     * 升级
     */
    String UPGRADE = "upgrade";
//	----------------------------交易指令------------------------
    /**
     * 确认交易
     */
    String CONFIRM_TRADE = "confirmTrade";
    /**
     * 添加金钱
     */
    String ADD_MONEY = "addMoney";
    /**
     * 添加物品
     */
    String ADD_ITEM = "addItem";
    /**
     * 发起交易
     */
    String REQUEST_TRADE = "requestTrade";
    /**
     * 上架
     */
    String PUT_ON_SHELVES = "putOnShelves";
    /**
     * 下架
     */
    String PULL_OFF_SHELVES = "pullOffShelves";
    /**
     * 摆摊
     */
    String STALL = "stall";
//	----------------------------物品指令------------------------
    /**
     * 装备物品
     */
    String PUT_ON_ITEM = "putOnItem";
    /**
     * 使用物品
     */
    String USE_ITEM = "useItem";
    /**
     * 放弃物品
     */
    String GIVE_UP_ITEM = "giveUpItem";
    /**
     * 销毁物品
     */
    String DESTROY_ITEM = "destroyItem";
    /**
     * 卸下物品
     */
    String TAKE_DOWN_ITEM = "takeDownItem";
    /**
     * 拾取物品
     */
    String PICK_UP_ITEM = "pickUpItem";
    /**
     * 拆分物品
     */
    String SPLIT_ITEM = "splitItem";
//	----------------------------物品指令------------------------
    /**
     * 拾取金币
     */
    String PICK_UP_MONEY = "pickUpMoney";
    /**
     * 丢弃金币
     */
    String GIVE_UP_MONEY = "giveUpMoney";
// -----------------------------怪物指令------------------------
    /**
     * 怪物死亡
     */
    String MONSTER_DEATH = "monsterDeath";
    /**
     * 怪物生成
     */
    String MONSTER_PRODUCE = "monsterProduce";
    //-------------------------地图指令----------------------
    /**
     * 切换地图(传送门)
     */
    String MAP_CHANGE = "mapChange";
}
