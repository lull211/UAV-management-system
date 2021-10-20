-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('任务监控', '0', '1', 'missionMonitor', 'missionMonitor/missionMonitor/index', 1, 0, 'C', '0', '0', 'missionMonitor:missionMonitor:list', '#', 'admin', sysdate(), '', null, '任务监控菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('任务监控查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'missionMonitor:missionMonitor:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('任务监控新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'missionMonitor:missionMonitor:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('任务监控修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'missionMonitor:missionMonitor:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('任务监控删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'missionMonitor:missionMonitor:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('任务监控导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'missionMonitor:missionMonitor:export',       '#', 'admin', sysdate(), '', null, '');