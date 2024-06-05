package com.leeeunsol.bms.service;

import com.leeeunsol.bms.dto.UserDTO;
import com.leeeunsol.bms.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

import static com.leeeunsol.bms.common.MyBatisTemplate.getSqlSession;

public class UserService {


    public UserDTO login(UserDTO userDTO) {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserDTO userDto = userMapper.login(userDTO);
        sqlSession.close();
        return userDto;
    }

    public boolean joinMember(UserDTO userDTO) {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.registerUserInfo(userDTO);
        if(result>0){
            sqlSession.commit();
            return true;
        }else{
            sqlSession.rollback();
            return false;
        }

    }

    public boolean existUserId(String userId) {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.existUserId(userId);
        return result>0;
    }
}
