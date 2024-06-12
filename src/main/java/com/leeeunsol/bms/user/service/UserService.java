package com.leeeunsol.bms.user.service;

import com.leeeunsol.bms.common.dto.CompanyDTO;
import com.leeeunsol.bms.common.dto.UserDTO;
import com.leeeunsol.bms.user.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

import static com.leeeunsol.bms.config.MyBatisTemplate.getSqlSession;

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

    public boolean findTransferAuthApplication(String userId) {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.existCompanyInfo(userId);
        return result>0;
    }

    public boolean registerCompanyInfo(CompanyDTO companyDTO) {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.registerCompanyInfo(companyDTO);
        if(result>0){
            sqlSession.commit();
            return true;
        }else{
            sqlSession.rollback();
            return false;
        }
    }
}
