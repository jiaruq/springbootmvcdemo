package com.neusoft.busmis.security.service;

import java.util.List;

import com.neusoft.busmis.security.model.RoleModel;

//角色业务接口
public interface IRoleService {
	
	public void add(RoleModel role) throws Exception;
	
	public void modify(RoleModel role) throws Exception;
	
	public void delete(RoleModel role) throws Exception;
	//取得所有角色
	public List<RoleModel> getListByAll() throws Exception;
	//取得指定的角色
	public RoleModel getByNo(int no) throws Exception;
	//取得指定用户的角色列表
	public List<RoleModel> getListByUser(String userid) throws Exception;
	//取得所有角色的个数
	public int getCountByAll() throws Exception;
	

}
