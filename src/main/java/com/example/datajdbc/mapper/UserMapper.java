package com.example.datajdbc.mapper;

import com.example.datajdbc.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface UserMapper {
    @Select("select * from _User where userId=#{id}")
    public User getUserById(Integer id);

    @Select("select * from _User")
    public List<User> getAllUser();

    @Delete("delete from _User where userId =#{id}")
    public void deleteUserById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "userId")
    @Insert("insert into _User(userName,userSex,openid,grade,contactType,contactDetail) values(#{userName},#{userSex},#{openid},#{grade},#{contactType},#{contactDetail})")
    public void insertUser(User user);

    @Update("update _User set userName=#{userName} where userId=#{id}")
    public void updateUser(User user);

    @Select("select * from _User where openid=#{openid}")
    public User judge(String openid);
}
