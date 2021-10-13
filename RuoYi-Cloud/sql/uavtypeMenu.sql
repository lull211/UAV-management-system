-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('uavtype', '3', '1', 'uavtype', 'uavtype/uavtype/index', 1, 0, 'C', '0', '0', 'uavtype:uavtype:list', '#', 'admin', sysdate(), '', null, 'uavtype菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('uavtype查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'uavtype:uavtype:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('uavtype新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'uavtype:uavtype:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('uavtype修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'uavtype:uavtype:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('uavtype删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'uavtype:uavtype:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('uavtype导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'uavtype:uavtype:export',       '#', 'admin', sysdate(), '', null, '');