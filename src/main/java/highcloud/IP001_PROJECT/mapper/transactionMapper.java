package highcloud.IP001_PROJECT.mapper;

import highcloud.IP001_PROJECT.domain.Transaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface transactionMapper {
    @Insert("insert into buy values(NULL,'${who}',${what},CURRENT_TIMESTAMP(),'${addr}',${money})")
    public boolean putTran(@Param("who") String who, @Param("what") int id, @Param("addr") String addr, @Param("money") double money);

    @Select("select buy.who, product.title , buy.when, buy.addr, buy.money from buy left join product on buy.what = product.ID where who='${who}'  order by  buy.when desc;")
    public List<Transaction> getTransaction(@Param("who")String who);
}
