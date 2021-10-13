-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('任务等级', '3', '1', 'missionlevel', 'missionlevel/missionlevel/index', 1, 0, 'C', '0', '0', 'missionlevel:missionlevel:list', '#', 'admin', sysdate(), '', null, '任务等级菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('任务等级查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'missionlevel:missionlevel:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('任务等级新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'missionlevel:missionlevel:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('任务等级修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'missionlevel:missionlevel:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('任务等级删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'missionlevel:missionlevel:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('任务等级导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'missionlevel:missionlevel:export',       '#', 'admin', sysdate(), '', null, '');