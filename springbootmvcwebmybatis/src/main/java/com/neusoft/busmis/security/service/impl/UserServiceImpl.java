package com.neusoft.busmis.security.service.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.busmis.security.dao.IUserDao;
import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;


//用户的业务实现类
@Service("userService23")

public class UserServiceImpl implements IUserService {
	//取得User的DAO接口对象
	
	private SqlSessionFactory sessionfactory = null;
	private String name = null;
	private int age = 0;
	@Autowired
	private IUserDao userDao = null;
	
	
	
	public void setSessionfactory(SqlSessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//@Autowired
	public UserServiceImpl() {
		System.out.println("000");
	}
	//@Autowired
    public UserServiceImpl(SqlSessionFactory sessionfactory) {
    	this.sessionfactory = sessionfactory;
    	System.out.println("111");
	}
	//@Autowired
	public UserServiceImpl(SqlSessionFactory sessionfactory, String name, int age) {
		super();
		this.sessionfactory = sessionfactory;
		this.name = name;
		this.age = age;
		System.out.println("222");
	}
	@Override
	public void register(UserModel userModel) throws Exception {
		//调用DAO接口的方法
		userDao.create(userModel);
	}
	@Override
	public void modify(UserModel userModel) throws Exception {
		//调用DAO接口的方法
		userDao.update(userModel);
		System.out.println("使用MyBatis API执行修改");
	}
	@Override
	public void changePassword(String id, String password) throws Exception {
		
	}
	@Override
	public void changeRole(String id, String role) throws Exception {
	}
	@Override
	public boolean validate(String id, String password) throws Exception {
		boolean result=false;
		
		UserModel um=userDao.selectById(id);
		if(um!=null&&um.getPassword()!=null&&um.getPassword().equals(password)) {
			result=true;
		}
		
		return result;
	}
	@Override
	public void active(String id) throws Exception {
		
	}
	@Override
	public void disable(String id) throws Exception {
		
	}
	@Override
	public void delete(UserModel userModel) throws Exception {
		//调用DAO接口的方法
		userDao.delete(userModel);
		System.out.println("使用MyBatis API执行删除");
	}
	@Override
	public List<UserModel> getListByAll() throws Exception {
		List<UserModel> list=userDao.selectListByAll();
		//提交事务
		System.out.println("使用MyBatis API执行查询");
		return list;
	}
	

	@Override
	public UserModel getById(String id) throws Exception {
		return userDao.selectById(id);
	}
	//rows：每屏显示的个数， page:页号
	@Override
	public List<UserModel> getListByAllWithPage(int rows, int page) throws Exception {
		//调用DAO接口的方法
		List<UserModel> list=userDao.selectListByAllWithPage(rows*(page-1), rows);
		System.out.println("使用MyBatis API执行查询-分页");
		return list;
	}
	@Override
	public void addRoles(String userId, int[] roleNos) throws Exception {
		//每次增加角色前，推荐把原有的角色删除
		userDao.deleteRoles(userId);
		//再增加新的角色
		userDao.addRoles(userId, roleNos);

	}
	@Override
	public List<UserModel> getListByCondition(int roleNo, String keyName, int minAge, int maxAge, Date startDate,
			Date endDate) throws Exception {
		if(keyName!=null&&keyName.trim().length()>0) {
			keyName="%"+keyName+"%";
		}
		//调用DAO接口的方法
		List<UserModel> list=userDao.selectListByCondition(roleNo, keyName, minAge, maxAge, startDate, endDate);
		//提交事务
		return list;
	}
	@Override
	public void addRole(String id, int roleNo) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<UserModel> getUserListByRole(int roleNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getCountByUserAndRoles(String id, int roleNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<ModuleModel> getModuleListByUser(String userid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
