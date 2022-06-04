package highcloud.IP001_PROJECT.mapper;

import highcloud.IP001_PROJECT.domain.Member;
import highcloud.IP001_PROJECT.domain.MemberInfo;
import highcloud.IP001_PROJECT.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface memberMapper {

    @Select("select * from member where ID='${id}'")
    Member getMember(@Param("id") String id);

    @Insert("insert into member values('${id}', '${pwd}', '${name}', '${email}', '${phone}', default ,'${addr}')")
    public int putMember(@Param("id") String id, @Param("name") String name,
                  @Param("pwd") String pwd, @Param("email") String email,
                  @Param("phone") String phone, @Param("addr") String addr);

    @Update("update member set PWD='${pwd}', EMAIL='${email}', PHONE='${phone}',ADDR='${addr}' where ID='${id}' ")
    public int update(@Param("id") String id, @Param("name") String name,
                      @Param("pwd") String pwd, @Param("email") String email,
                      @Param("phone") String phone, @Param("addr") String addr);

    @Select("select * from member")
    List<Member> getMembers();

    @Delete("delete from member where ID='${who}';")
    public int delete(@Param("who") String who);

    @Select("select who as 'id',member.name ,member.regdate as 'date', sum(money) as 'money'  from buy left join member on buy.who = member.id where name is not null group by who Order by money desc;")
    List<MemberInfo> getMemInfo();

    @Select("select member.id,member.name,member.regdate as 'date' from member left outer join buy on member.id = buy.who where buy.money is null order by member.id;")
    List<MemberInfo> getNotbuy();
}
