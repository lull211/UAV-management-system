-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('无人机归口部门', '3', '1', 'uavdepartment', 'uavdepartment/uavdepartment/index', 1, 0, 'C', '0', '0', 'uavdepartment:uavdepartment:list', '#', 'admin', sysdate(), '', null, '无人机归口部门菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('无人机归口部门查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'uavdepartment:uavdepartment:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('无人机归口部门新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'uavdepartment:uavdepartment:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('无人机归口部门修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'uavdepartment:uavdepartment:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('无人机归口部门删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'uavdepartment:uavdepartment:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('无人机归口部门导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'uavdepartment:uavdepartment:export',       '#', 'admin', sysdate(), '', null, '');