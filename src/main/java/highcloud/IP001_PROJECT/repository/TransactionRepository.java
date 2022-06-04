package highcloud.IP001_PROJECT.repository;

import highcloud.IP001_PROJECT.mapper.transactionMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepository {
    private transactionMapper mapper;

    public TransactionRepository(transactionMapper mapper){
        this.mapper = mapper;
    }

    public boolean putTran(String who, int what, String addr, double money){
        return mapper.putTran(who,what,addr, money);
    }
}
