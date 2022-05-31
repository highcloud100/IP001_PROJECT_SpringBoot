package highcloud.IP001_PROJECT.mapper;

import highcloud.IP001_PROJECT.domain.Member;
import highcloud.IP001_PROJECT.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface memberMapper {

    @Select("select * from member where ID='${id}'")
    Member getMember(@Param("id") String id);

    @Insert("insert into member values('${id}', '${pwd}', '${name}', '${email}', '${phone}', NULL ,'${addr}')")
    public int putMember(@Param("id") String id, @Param("name") String name,
                  @Param("pwd") String pwd, @Param("email") String email,
                  @Param("phone") String phone, @Param("addr") String addr);



}
