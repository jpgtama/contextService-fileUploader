/**
 * 
 */
package com.evan.context_service.fileUploader.db.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.evan.context_service.fileUploader.db.entity.User;

/**
 * @author 310199253
 *
 */
public interface UserMapper {

	
	@Select("SELECT * from user WHERE id = #{id}")
	User select(int id);
	
	@Insert("INSERT into user(uid, extId, name) VALUES(#{uid, jdbcType=INTEGER}, #{extId, jdbcType=INTEGER}, #{name, jdbcType=VARCHAR})")
	@Options(useGeneratedKeys=true)
	int insert(User user);
	
	@Update("UPDATE user SET uid=#{uid, jdbcType=INTEGER}, extId =#{extId, jdbcType=INTEGER}, name=#{name, jdbcType=VARCHAR} WHERE id =#{id}")
	int update(User user);
	
	@Delete("DELETE FROM user WHERE id =#{id}")
	int delete(int id);
	
}
