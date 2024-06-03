package com.leeeunsol.bms.service;

import com.leeeunsol.bms.dto.UserDTO;
import com.leeeunsol.bms.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

import static com.leeeunsol.bms.common.MyBatisTemplate.getSqlSession;

public class UserService {


    public UserDTO login(UserDTO userDTO) {

        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserDTO result = userMapper.login(userDTO);

        sqlSession.close();
        return result;
    }
}
