# 个人博客后台系统设计（管理员）
## 系统功能
- 网站管理`对网站一些基础信息的维护`
 
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

## 功能介绍

### 1. 网站管理
- 包含网站标题、网站副标题、网站描述、网站icon、网站logo、是否允许用户注册、网站关键词、网站网址等。

### 2. 用户管理
- 角色管理
    - 角色id、角色名称、创建时间等。
- 权限管理
    - 权限id、权限名称、创建时间等。
- 用户管理
    - 包含用户id、用户ip、用户名、用户账号、用户角色、用户邮箱、用户头像、用户性别、注册时间、用户生日、用户年龄、用户手机号等。
    
### 3. 博客管理
- 包含博客id、博客标题、博客正文、发表时间、状态、发表用户、点赞数、评论数、游览量等。

### 4. 评论管理
- 博客评论管理
    - 评论id、评论博客、评论用户、评论时间、评论内容、评论状态等。
- 用户评论管理
    - 评论id、针对某条评论发出的评论、评论用户、评论时间、评论内容、评论状态等。
    
### 5. 友链管理
- 友链id、友链名称、友链地址、友链logo、友链备注、创建时间、友链状态等。

### 6. 黑名单管理
- 黑名单id、黑名单ip、黑名单备注、黑名单状态、创建时间等。

### 7. 标签管理
- 标签id、标签名称、创建时间等。

### 8. 菜单管理
- 菜单id、父菜单id、菜单名称、父菜单名称、创建时间等。

### 9. 分类管理
    文章分类维护
    
### 10. 日志管理
- 系统日志
    - 日志id、日志等级、日志内容、创建时间等。
- 操作日志
    - 日志id、用户id、用户ip、日志内容、操作时间等。
    

## 表结构设计
### 1. 网站基础信息表(blog_site_info)
```
CREATE TABLE `blog_site_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `site_title` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '网站标题',
  `site_sub_title` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '网站副标题',
  `site_desc` text COLLATE utf8_bin COMMENT '网站描述',
  `site_icon` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '网站icon',
  `site_logo` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '网站logo',
  `open_regist` tinyint(1) DEFAULT '0' COMMENT '开放注册0 否,1 是',
  `site_keyword` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '网站关键词',
  `site_url` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '网站地址',
  `site_owner` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '网站拥有者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='网站基础信息';
```
### 2. 用户表(blog_user)
### 3. 角色表
### 4. 权限表
### 5. 用户角色表
### 6. 角色权限表
### 7. 博客表
### 8. 评论表
### 9. 友链表
### 10. 黑名单表
### 11. 标签表
### 12. 菜单表(可放在权限表)
### 13. 分类表
### 14. 日志表
