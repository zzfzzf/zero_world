/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/7/26 星期二 15:59:25                       */
/*==============================================================*/


drop table if exists g_area;

drop table if exists g_bag;

drop table if exists g_bag_item;

drop table if exists g_buff;

drop table if exists g_building;

drop table if exists g_equip;

drop table if exists g_equip_item;

drop table if exists g_genius;

drop table if exists g_image;

drop table if exists g_items;

drop table if exists g_land;

drop table if exists g_monster;

drop table if exists g_npc;

drop table if exists g_race;

drop table if exists g_race_genius;

drop table if exists g_role;

drop table if exists g_role_buff;

drop table if exists g_role_friend;

drop table if exists g_role_skill;

drop table if exists g_skill;

drop table if exists g_skill_buff;

drop table if exists g_vocation;

drop table if exists g_vocation_skill;

drop table if exists g_voice;

drop table if exists z_position;

drop table if exists z_position_power;

drop table if exists z_power;

drop table if exists z_user;

drop table if exists z_user_position;

/*==============================================================*/
/* Table: g_area                                                */
/*==============================================================*/
create table g_area
(
   id                   char(32) not null,
   name                 varchar(50),
   total_num            int,
   online_num           int,
   offline_num          int,
   create_time          bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: g_bag                                                 */
/*==============================================================*/
create table g_bag
(
   id                   char(32) not null,
   name                 varchar(50),
   detail               varchar(50),
   grid                 int,
   primary key (id)
);

/*==============================================================*/
/* Table: g_bag_item                                            */
/*==============================================================*/
create table g_bag_item
(
   id                   char(32) not null,
   bag_id               char(32),
   item_id              char(32),
   number               int,
   primary key (id)
);

/*==============================================================*/
/* Table: g_buff                                                */
/*==============================================================*/
create table g_buff
(
   id                   char(32) not null,
   name                 varchar(50),
   detail               varchar(50),
   level                int,
   effect_image_id      char(32),
   primary key (id)
);

/*==============================================================*/
/* Table: g_building                                            */
/*==============================================================*/
create table g_building
(
   id                   char(32) not null,
   name                 varchar(50),
   detail               varchar(50),
   land_id              char(32),
   primary key (id)
);

/*==============================================================*/
/* Table: g_equip                                               */
/*==============================================================*/
create table g_equip
(
   id                   char(32) not null,
   detail               varchar(50),
   name                 varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Table: g_equip_item                                          */
/*==============================================================*/
create table g_equip_item
(
   id                   char(32) not null,
   equip_id             char(32),
   item_id              char(32),
   primary key (id)
);

/*==============================================================*/
/* Table: g_genius                                              */
/*==============================================================*/
create table g_genius
(
   id                   char(32) not null,
   name                 varchar(50),
   detail               varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Table: g_image                                               */
/*==============================================================*/
create table g_image
(
   id                   char(32) not null,
   name                 varchar(50),
   detail               varchar(50),
   url                  varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Table: g_items                                               */
/*==============================================================*/
create table g_items
(
   id                   char(32) not null,
   detail               varchar(50),
   name                 varchar(50),
   level                bigint,
   quality              bigint comment '1 白色 2 绿色 3 蓝色 4 紫色 5 橙色',
   type                 bigint comment '0 消耗品 1 是装备',
   icon                 varchar(50),
   status               bigint comment '0 未使用 1已使用',
   strength             bigint(50),
   agility              bigint(50),
   intellect            bigint(50),
   lucky                bigint(50),
   profile              varchar(50),
   property             bigint comment '基本属性 ',
   price                bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: g_land                                                */
/*==============================================================*/
create table g_land
(
   id                   char(32) not null,
   role_id              char(32),
   name                 varchar(50),
   detail               varchar(50),
   size                 int,
   start_time           timestamp,
   end_time             timestamp,
   own_time             timestamp,
   is_rent              int comment '0未出租 1已出租',
   primary key (id)
);

/*==============================================================*/
/* Table: g_monster                                             */
/*==============================================================*/
create table g_monster
(
   id                   char(32) not null,
   attack               bigint(50),
   defens               bigint(50),
   quality              int,
   name                 varchar(50),
   level                int,
   blood                int,
   energy               int,
   strength             int,
   agility              int,
   intellect            int,
   lucky                int,
   genius_id            char(32),
   type                 int comment '0普通小怪 1野外boss 2特殊怪物',
   primary key (id)
);

/*==============================================================*/
/* Table: g_npc                                                 */
/*==============================================================*/
create table g_npc
(
   id                   char(32) not null,
   name                 varchar(50),
   detail               varchar(50),
   type                 int comment '0 普通村民 1村长  2技能使者 3商店',
   gender               int comment '0 女 1男',
   primary key (id)
);

/*==============================================================*/
/* Table: g_race                                                */
/*==============================================================*/
create table g_race
(
   id                   char(32) not null,
   name                 varchar(50),
   detail               varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Table: g_race_genius                                         */
/*==============================================================*/
create table g_race_genius
(
   id                   char(32) not null,
   race_id              char(32),
   genius_id            char(32),
   primary key (id)
);

/*==============================================================*/
/* Table: g_role                                                */
/*==============================================================*/
create table g_role
(
   id                   char(32) not null,
   name                 varchar(50),
   blood                varchar(50) comment '生命',
   energy               varchar(50) comment '能量',
   level                int,
   experience           int,
   gender               int comment '0女 1男',
   vocation_id          char(32),
   status               int comment '0 不在线 1在线 2死亡 10角色已删除',
   bag_id               char(32),
   equip_id             char(32),
   strength             int,
   agility              int,
   intellect            int,
   lucky                int,
   conditions           varchar(50) comment '0 饥饿 1 饱食',
   race_id              char(32),
   attack               int,
   defens               int,
   head_image_id        char(32),
   user_id              char(32),
   area                 char(32),
   primary key (id)
);

/*==============================================================*/
/* Table: g_role_buff                                           */
/*==============================================================*/
create table g_role_buff
(
   id                   char(32) not null,
   buff_id              char(32),
   role_id              char(32),
   time                 bigint comment '持续时间',
   start_time           bigint,
   end_time             bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: g_role_friend                                         */
/*==============================================================*/
create table g_role_friend
(
   id                   char(32) not null,
   friend_id            char(32),
   role_id              char(32),
   detail               varchar(50),
   "bigint"             timestamp,
   favor                int,
   primary key (id)
);

/*==============================================================*/
/* Table: g_role_skill                                          */
/*==============================================================*/
create table g_role_skill
(
   id                   char(32) not null,
   skill_id             char(32),
   role_id              char(32),
   level                int,
   proficient           int comment '熟练度',
   primary key (id)
);

/*==============================================================*/
/* Table: g_skill                                               */
/*==============================================================*/
create table g_skill
(
   id                   char(32) not null,
   detail               varchar(50),
   name                 varchar(50),
   level                int comment '需求等级',
   type                 int comment '0 生活技能 1 战斗技能 ',
   time                 int comment '秒',
   scope                int,
   requirement          int comment '施法条件',
   target_typee         int comment '0单个 1多个 2范围内',
   target_num           int comment '目标数量 0无限 N n个',
   primary key (id)
);

/*==============================================================*/
/* Table: g_skill_buff                                          */
/*==============================================================*/
create table g_skill_buff
(
   id                   char(32) not null,
   skill_id             char(32),
   buff_id              char(32),
   primary key (id)
);

/*==============================================================*/
/* Table: g_vocation                                            */
/*==============================================================*/
create table g_vocation
(
   id                   char(32) not null,
   detail               varchar(50),
   name                 varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Table: g_vocation_skill                                      */
/*==============================================================*/
create table g_vocation_skill
(
   id                   char(32) not null,
   vocation_id          char(32),
   skill_id             char(32),
   primary key (id)
);

/*==============================================================*/
/* Table: g_voice                                               */
/*==============================================================*/
create table g_voice
(
   id                   char(32) not null,
   name                 varchar(50),
   detail               varchar(50),
   url                  varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Table: z_position                                            */
/*==============================================================*/
create table z_position
(
   id                   char(32) not null,
   name                 varchar(50),
   detail               varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Table: z_position_power                                      */
/*==============================================================*/
create table z_position_power
(
   id                   char(32) not null,
   power_id             char(32),
   position_id          char(32),
   primary key (id)
);

/*==============================================================*/
/* Table: z_power                                               */
/*==============================================================*/
create table z_power
(
   id                   char(32) not null,
   name                 varchar(50),
   detail               varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Table: z_user                                                */
/*==============================================================*/
create table z_user
(
   id                   varchar(50) not null,
   username             varchar(50),
   password             varchar(16),
   nick_name            varchar(50),
   head_image_id        varchar(50),
   special_sign         varchar(50),
   status               int comment '1在线 0 不在线 2 停用 3 正常',
   vip                  int,
   money                int,
   qq                   varchar(50),
   phone                varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Table: z_user_position                                       */
/*==============================================================*/
create table z_user_position
(
   id                   char(32) not null,
   position_id          char(32),
   user_id              char(32),
   primary key (id)
);

