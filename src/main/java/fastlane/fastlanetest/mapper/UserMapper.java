package fastlane.fastlanetest.mapper;

import fastlane.fastlanetest.dto.UserDto;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<UserDto> findAll();

    @Select("SELECT * FROM user where id = #{id}")
    UserDto findById(String id);

    @Insert("INSERT INTO user (id, password) values (#{id}, #{password})")
    void save(@Param("id") String id, @Param("password") String password);

    @Update("UPDATE user SET password = #{password} WHERE id = #{id}")
    void update(@Param("password") String password, @Param("id") String id);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void delete(@Param("id") String id);

}
