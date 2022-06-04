package highcloud.IP001_PROJECT.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface transactionMapper {
    @Insert("insert into buy values(NULL,'${who}',${what},CURRENT_TIMESTAMP(),'${addr}',${money})")
    public boolean putTran(@Param("who") String who, @Param("what") int id, @Param("addr") String addr, @Param("money") double money);

}
