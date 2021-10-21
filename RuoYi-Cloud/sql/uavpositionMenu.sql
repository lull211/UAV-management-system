-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('无人机实时位置测试', '3', '1', 'uavposition', 'uavposition/uavposition/index', 1, 0, 'C', '0', '0', 'uavposition:uavposition:list', '#', 'admin', sysdate(), '', null, '无人机实时位置测试菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('无人机实时位置测试查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'uavposition:uavposition:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('无人机实时位置测试新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'uavposition:uavposition:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('无人机实时位置测试修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'uavposition:uavposition:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('无人机实时位置测试删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'uavposition:uavposition:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('无人机实时位置测试导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'uavposition:uavposition:export',       '#', 'admin', sysdate(), '', null, '');