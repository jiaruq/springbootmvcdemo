package com.neusoft.busmis.security.service.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.neusoft.busmis.security.dao.IUserDao;
import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;
//用户的业务实现类
@Service("userService04")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {

	//注册用户
	@Override
	public void register(UserModel userModel) throws Exception {

		userDao.create(userModel);
	}
	
	//修改用户
	@Override
	public void modify(UserModel userModel) throws Exception {
		
		//调用DAO接口方法
		userDao.update(userModel);
	}
	
	//修改密码
	@Override
	public void changePassword(String id, String password) throws Exception {
		UserModel um=userDao.selectById(id);
		um.setPassword(password);
		userDao.update(um);
	}
	
	//修改角色
	@Override
	public void changeRole(String id, String role) throws Exception {
		
	}
	
	//验证用户合法性
	@Override
	public boolean validate(String id, String password) throws Exception {

		//调用DAO接口方法
		boolean result=false;
		UserModel um=userDao.selectById(id);
		if(um!=null&&um.getPassword()!=null&&um.getPassword().equals(password)) {
			result=true;
		}
		return result;
	}
	
	//激活用户，可以登录
	@Override
	public void active(String id) throws Exception {
		UserModel um=userDao.selectById(id);
		um.setStatus("Y");
		userDao.update(um);
	}
		
	//终止用户，此用户不能登录
	@Override
	public void disable(String id) throws Exception {
		UserModel um=userDao.selectById(id);
		um.setStatus("N");
		userDao.update(um);
	}
	
	//删除用户
	@Override
	public void delete(UserModel userModel) throws Exception {

		//调用DAO接口方法
		userDao.delete(userModel);

	}
	
	//取得所有用户列表
	@Override
	public List<UserModel> getListByAll() throws Exception {
		//调用DAO接口方法
		//List<UserModel> list=userDao.selectListByAll();

		return userDao.selectListByAll();
	}
	
	@Override
	public UserModel getById(String id) throws Exception {

		return userDao.selectById(id);
		}
	//rows：每屏显示的个数， page:页号
	@Override
	public List<UserModel> getListByAllWithPage(int rows, int page) throws Exception {


		return userDao.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public void addRole(String id, int roleNo) throws Exception {

		//调用DAO接口的方法
		//每次增加角色前，推荐把原有的角色删除
		//userDao.deleteRoles(id);
		//再增加新的角色
		userDao.addRole(id, roleNo);
		
	}

	@Override
	public void addRoles(String userId, int[] roleNos) throws Exception {

		//调用DAO接口的方法
		//每次增加角色前，推荐把原有的角色删除
		userDao.deleteRoles(userId);
		//再增加新的角色
		userDao.addRoles(userId, roleNos);
		
	}

	@Override
	public int getCountByUserAndRoles(String id, int roleNo) throws Exception {

		//调用DAO接口方法
		UserModel um=userDao.selectById(id);
		int count=0;
		if(um!=null) {
			count=userDao.selectCountByUserAndRoles(id,roleNo);
		}
		return count;
	}

	@Override
	public List<UserModel> getUserListByRole(int roleNo) throws Exception {

		//调用DAO接口方法
		//List<UserModel> list=userDao.selectUserListByRole(roleNo);
		
		return userDao.selectUserListByRole(roleNo);
	}

	@Override
	public List<ModuleModel> getModuleListByUser(String userid) throws Exception {
		//List<ModuleModel> list=userDao.selectModuleListByUser(userid);
		return userDao.selectModuleListByUser(userid);
	}

	@Override
	public List<UserModel> getListByCondition(int roleNo, String keyName, int minAge, int maxAge, Date startDate,
			Date endDate) throws Exception {
		

		if(keyName!=null&&keyName.trim().length()>0) {
			keyName="%"+keyName+"%";
		}
		//调用DAO接口的方法
		//List<UserModel> list=userDao.selectListByCondition(roleNo, keyName, minAge, maxAge, startDate, endDate);

		return userDao.selectListByCondition(roleNo, keyName, minAge, maxAge, startDate, endDate);
	}


}
