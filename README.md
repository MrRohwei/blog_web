# 个人博客后台系统设计（管理员）
<a href="#gnjs">1. 功能介绍</a>

<a href="#bjgsj">2. 表结构设计</a>

<a href="#jksj">3. 接口设计</a>
### 1.系统功能
- 网站管理
- 用户管理
- 博客管理
- 评论管理
- 友链管理
- 黑名单
- 标签管理
- 菜单管理
- 权限管理
- 分类管理
- 日志管理

### 2.功能介绍<a name="gnjs"></a>
#### 1. 网站管理
`包含网站标题、网站副标题、网站描述、网站icon、网站logo、是否允许用户注册、网站关键词、网站网址等。`

#### 2. 用户管理
- 角色管理
    `角色id、角色名称、创建时间等。`
- 权限管理
    `权限id、权限名称、创建时间等。`
- 用户管理
    `包含用户id、用户ip、用户名、用户账号、用户角色、用户邮箱、用户头像、用户性别、注册时间、用户生日、用户年龄、用户手机号等。`   

#### 3. 博客管理
`包含博客id、博客标题、博客正文、发表时间、状态、发表用户、点赞数、评论数、游览量等。`

#### 4. 评论管理
- 博客评论管理
    `评论id、评论博客、评论用户、评论时间、评论内容、评论状态等。`
- 用户评论管理
    `评论id、针对某条评论发出的评论、评论用户、评论时间、评论内容、评论状态等。`
    
#### 5. 友链管理
`友链id、友链名称、友链地址、友链logo、友链备注、创建时间、友链状态等。`

#### 6. 黑名单管理
`黑名单id、黑名单ip、黑名单备注、黑名单状态、创建时间等。`

#### 7. 标签管理
`标签id、标签名称、创建时间等。`

#### 8. 菜单管理
`菜单id、父菜单id、菜单名称、父菜单名称、创建时间等。`

#### 9. 分类管理
`文章分类维护`
    
#### 10. 日志管理
- 系统日志
    `日志id、日志等级、日志内容、创建时间等。`
- 操作日志
    `日志id、用户id、用户ip、日志内容、操作时间等。`
    

## 表结构设计<a name="bjgsj"></a>
#### 1. 网站基础信息表<a name="blog_site_info"></a>
```
CREATE TABLE `blog_site_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `site_title` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '网站标题',
  `site_sub_title` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '网站副标题',
  `site_desc` text C、OLLATE utf8_bin COMMENT '网站描述',
  `site_icon` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '网站icon',
  `site_logo` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '网站logo',
  `open_regist` tinyint(1) DEFAULT '0' COMMENT '开放注册0 否,1 是',
  `site_keyword` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '网站关键词',
  `site_url` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '网站地址',
  `site_owner` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '网站拥有者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='网站基础信息';
```
#### 2. 用户表<a name="blog_user"></a>
```
CREATE TABLE `blog_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户注册地IP',
  `username` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户账号',
  `password` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `nickname` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户昵称',
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户邮箱',
  `head_img` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '用户头像',
  `gender` tinyint(1) DEFAULT '1' COMMENT '用户性别：0 女，1 男',
  `birthday` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户生日',
  `mobile` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '用户手机号',
  `status` char(2) COLLATE utf8_bin NOT NULL COMMENT '用户状态：0 禁用，1 弃用',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `deleted_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表'

```
#### 3. 角色表
```
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `created_time` datetime NOT NULL,
  `deleted_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色表'
```
#### 4. 权限表
```
CREATE TABLE `permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(100) COLLATE utf8_bin NOT NULL,
  `created_time` datetime NOT NULL,
  `deleted_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='权限表'
```
#### 5. 用户角色表
```
CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户角色表'
```
#### 6. 角色权限表
```
CREATE TABLE `role_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色权限表'
```
#### 7. 博客表
```
CREATE TABLE `blogs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '博客标题',
  `content` text COLLATE utf8_bin NOT NULL COMMENT '博客正文',
  `status` char(2) COLLATE utf8_bin NOT NULL COMMENT '博客状态：0 禁用，1 启用',
  `user_id` int(11) NOT NULL COMMENT '发表用户',
  `like_num` int(11) DEFAULT NULL COMMENT '点赞数',
  `comment_num` int(11) DEFAULT NULL COMMENT '评论数',
  `look_num` int(11) DEFAULT NULL COMMENT '游览量',
  `created_time` datetime NOT NULL,
  `deleted_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='博客表'
```
#### 8. 评论表
```
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `comment` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '评论内容',
  `status` char(2) COLLATE utf8_bin NOT NULL COMMENT '评论状态',
  `type` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '评论类型：1 博客，2 评论',
  `biz_id` int(11) NOT NULL COMMENT '业务ID，根据评论类型指定对应ID',
  `created_time` datetime NOT NULL,
  `deleted_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='评论表'
```
#### 9. 友链表
```
CREATE TABLE `frend_links` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `link_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '友链名称',
  `link_href` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '友链地址',
  `link_logo` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '友链logo',
  `link_remark` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '友链备注',
  `status` char(2) COLLATE utf8_bin DEFAULT NULL COMMENT '友链状态',
  `created_time` datetime NOT NULL,
  `deleted_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='友链表'
```
#### 10. 黑名单表
```
CREATE TABLE `blacks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(50) COLLATE utf8_bin NOT NULL,
  `remark` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `created_time` datetime NOT NULL,
  `deleted_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='黑名单表'
```
#### 11. 标签表
```
CREATE TABLE `tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `status` char(2) COLLATE utf8_bin DEFAULT NULL,
  `created_time` datetime NOT NULL,
  `deleted_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='标签表'

```
#### 12. 菜单表(可放在权限表)
```
CREATE TABLE `menus` (
  `id` int(11) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `menu_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `created_time` datetime NOT NULL,
  `deleted_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='菜单表'
```
#### 13. 分类表
#### 14. 日志表
```
CREATE TABLE `blog_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `model_type` varchar(20) COLLATE utf8_bin NOT NULL,
  `operation` varchar(20) COLLATE utf8_bin NOT NULL,
  `created_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='日志表'
```
