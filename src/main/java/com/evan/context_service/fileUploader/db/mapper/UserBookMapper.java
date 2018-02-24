/**
 * 
 */
package com.evan.context_service.fileUploader.db.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.evan.context_service.fileUploader.db.entity.UserBook;

/**
 * @author 310199253
 *
 */
public interface UserBookMapper {

	
	@Select("SELECT * from userBook WHERE id = #{id}")
	UserBook select(int id);
	
	@Insert("INSERT into userBook(uid, userId, bookId) VALUES(#{uid, jdbcType=VARCHAR}, #{userId, jdbcType=INTEGER}, #{bookId, jdbcType=INTEGER})")
	@Options(useGeneratedKeys=true)
	void insert(UserBook userBook);
	
	@Update("UPDATE userBook SET uid=#{uid, jdbcType=VARCHAR}, userId =#{userId, jdbcType=INTEGER}, bookId=#{bookId, jdbcType=INTEGER} WHERE id =#{id}")
	void update(UserBook userBook);
	
	@Delete("DELETE FROM userBook WHERE id =#{id}")
	void delete(int id);
	
}
