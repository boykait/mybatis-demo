package com.boykait.user;

import com.boykait.user.mapper.UserMapper;
import com.boykait.user.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author boykait
 * @version 1.0
 * @date 2020/2/4 16:39
 */
public class TestMain {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<User> users = (List)sqlSession.selectList("xxxxx.listUsers", "1");
//        // 获取mapper代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        // 执行查询(CURD)操作
        doGetUserTest(mapper, "1");
        // 执行修改
//        doUpdateTest(mapper, "2");
        // 再次查询
        doGetUserTest(mapper, "1");
        sqlSession.commit();
        sqlSession.close();
    }

    private static List<User> doListUsersTest(UserMapper mapper) {
        return mapper.listUsers();
    }

    private static User doGetUserTest(UserMapper mapper, String id) {
        return mapper.getUserById(id);
    }

    private static Integer doAddTest(UserMapper mapper) {
        User u = new User();
        u.setUserName("xiaoming");
        u.setPassword("123456");
        u.setGender("男");
        u.setTelephone("1234567890");
        u.setEmail("xxx@126.com");
        u.setAddress("四川成都");
        return mapper.saveUser(u);
    }

    private static Integer doUpdateTest(UserMapper mapper, String id) {
        User u = new User();
        u.setId(id);
        u.setUserName("xiaoming1");
        u.setPassword("1234567");
        u.setGender("男");
        u.setTelephone("1234567890");
        u.setEmail("xxx@126.com");
        u.setAddress("四川成都");
        return mapper.updateUser(u);
    }

    private static Integer deleteUserTest(UserMapper mapper, String id) {
        return mapper.deleteUser(id);
    }
}
