package com.xms.day01;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.xms.day01.entity.User;
import com.xms.day01.mapping.UserMapperI;
import com.xms.day01.util.MyBatisUtil;

public class TestCRUDByAnnotationMapper {
	
	public void testAdd() {

	}
	
	public static void main(String[] args) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		User user= new User();
		user.setName("方宽宽");
		user.setAge(23);
		int add = mapper.add(user);
		sqlSession.close();
		System.out.println(add);
	}
	
	
	
	
}
