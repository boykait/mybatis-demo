package com.boykait.user;

import com.boykait.user.mapper.UserMapper;
import com.boykait.user.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionManager;

import java.io.InputStream;
import java.util.List;

/**
 * @author boykait
 * @version 1.0
 * @date 2020/2/9 13:18
 */
public class SqlSessionManagerTest {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 实例化sqlSessionManager
        SqlSessionManager sqlSessionManager = SqlSessionManager.newInstance(inputStream);
        // 开启管理SqlSession，创建一个SqlSession并存入到ThreadLocal中
        sqlSessionManager.startManagedSession();
        // 使用
        UserMapper mapper1 = sqlSessionManager.getMapper(UserMapper.class);
        List<User> users1 = mapper1.listUsers();
        users1.forEach(user -> System.out.println(user.toString()));
    }
}
