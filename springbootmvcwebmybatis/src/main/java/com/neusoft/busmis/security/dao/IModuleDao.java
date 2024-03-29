package com.neusoft.busmis.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.busmis.security.model.ModuleModel;

//系统功能模块DAO接口
@Mapper
public interface IModuleDao {

	public void create(ModuleModel module) throws Exception;
	public void update(ModuleModel module) throws Exception;
	public void delete(ModuleModel module) throws Exception;
	//只取得模块列表，不取得关联的功能列表。	
	public List<ModuleModel> selectListByAll() throws Exception;
	//取得模块列表，并取得关联的功能属性列表，使用内嵌式select方式
	public List<ModuleModel> selectListByAllWithFunctionsByNestedSelect() throws Exception;
	//取得模块列表，并取得关联的功能属性列表，使用内嵌式ResultMap方式
	public List<ModuleModel> selectListByAllWithFunctionsByNestedResultMap() throws Exception;
	
	//取得模块列表，并取得关联的角色属性列表，使用内嵌式select方式
	public List<ModuleModel> selectListByAllWithRolesByNestedSelect() throws Exception;
	//取得模块列表，并取得关联的角色属性列表，使用内嵌式ResultMap方式
	public List<ModuleModel> selectListByAllWithRolesByNestedResultMap() throws Exception;
	
	//取得模块列表，并取得关联的功能和角色属性列表，使用内嵌式select方式
	public List<ModuleModel> selectListByAllWithFunctionsAndRolesByNestedSelect() throws Exception;
	//取得模块列表，并取得关联的功能和角色属性列表，使用内嵌式ResultMap方式
	public List<ModuleModel> selectListByAllWithFunctionsAndRolesByNestedResultMap() throws Exception;
	
	public ModuleModel selectByNo(int no) throws Exception;
	public ModuleModel selectByNoWithFunctions(int no) throws Exception;
	//取得所有模块的个数
	public int selectCountByAll() throws Exception;
	//取得指定角色的模块列表
	public List<ModuleModel> selectListByRole(int roleNo) throws Exception;
	//取得指定模块和角色的关联个数，用于业务层检查此角色是否对此模块有权限
	//验证指定角色是否有此模块权限: 参数：模块编号，角色编号
	public boolean checkAccessForRole(int moduleNo,int roleNo) throws Exception;
	
}
