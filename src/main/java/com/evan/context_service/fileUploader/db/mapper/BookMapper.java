/**
 * 
 */
package com.evan.context_service.fileUploader.db.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.evan.context_service.fileUploader.db.entity.Book;

/**
 * @author 310199253
 *
 */
public interface BookMapper {

	
	@Select("SELECT * from book WHERE id = #{id}")
	Book select(int id);
	
	@Insert("INSERT into book(uid, name, filePath, hash, privateOnly) VALUES(#{uid, jdbcType=INTEGER}, #{name, jdbcType=VARCHAR}, #{filePath, jdbcType=VARCHAR}, #{hash, jdbcType=VARCHAR}, #{privateOnly, jdbcType=TINYINT})")
	@Options(useGeneratedKeys=true)
	int insert(Book book);
	
	@Update("UPDATE book SET uid=#{uid, jdbcType=INTEGER}, name =#{name, jdbcType=VARCHAR}, filePath=#{filePath, jdbcType=VARCHAR}, hash=#{hash, jdbcType=VARCHAR}, privateOnly=#{privateOnly, jdbcType=TINYINT} WHERE id =#{id}")
	int update(Book book);
	
	@Delete("DELETE FROM book WHERE id =#{id}")
	int delete(int id);
	
}
