package com.loveboy.sys.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.loveboy.sys.user.form.vo.SysUserInfoVo;

@Mapper
@Repository
public interface  SysUserMybaitisDaoMapper{
	
	
	 @Select("select * from SYS_USER_INFO where ID=#{id}")  //${userId}
	 public SysUserInfoVo getSysUserInfoById(@Param("id") Long id);
	 
	 
	 
	
//	 @Insert("INSERT INTO ${targetTable} (${targetFields}) Select ${sourceFields} from ${sourceTable} where id > ${idBegin} and id < ${idEnd}")  
//		public SysUserVo getSysUserInfoById(String reqId, Long userId);
//	 
//	 
//	@Insert("insert into users(name,age) values(#{name},#{age})")
//    public void insertT(User user);
//    
//    @Delete("delete from users where id=#{id}")
//    public void deleteById(int id);
//    
//    @Update("update users set name=#{name},age=#{age} where id=#{id}")
//    public void updateT(User user);
//    
//   
//    
//    @Select("select * from users")
//    public List<User> getAllUsers();
//    
//    
//	public int moveData(@Param("sourceTable") String sourceTableName,@Param("targetTable") String targetTableName,  
//            @Param("sourceFields") String sourceFields,@Param("targetFields") String targetFields,  
//            @Param("idBegin")int idBegin,@Param("idEnd")int idEnd);  
	
}
