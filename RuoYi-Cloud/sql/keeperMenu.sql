-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('保管员管理', '3', '1', 'keeper', 'keeper/keeper/index', 1, 0, 'C', '0', '0', 'keeper:keeper:list', '#', 'admin', sysdate(), '', null, '保管员管理菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('保管员管理查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'keeper:keeper:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('保管员管理新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'keeper:keeper:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('保管员管理修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'keeper:keeper:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('保管员管理删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'keeper:keeper:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('保管员管理导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'keeper:keeper:export',       '#', 'admin', sysdate(), '', null, '');