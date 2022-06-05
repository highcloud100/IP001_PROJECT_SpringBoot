package highcloud.IP001_PROJECT.repository;

import highcloud.IP001_PROJECT.domain.Transaction;
import highcloud.IP001_PROJECT.mapper.transactionMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepository {
    private transactionMapper mapper;

    public TransactionRepository(transactionMapper mapper){
        this.mapper = mapper;
    }

    public boolean putTran(String who, int what, String addr, double money){
        return mapper.putTran(who,what,addr, money);
    }

    public List<Transaction> getTransaction(String who){
        return mapper.getTransaction(who);
    }
}
