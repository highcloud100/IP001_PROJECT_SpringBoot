package highcloud.IP001_PROJECT.repository;

import highcloud.IP001_PROJECT.domain.Member;
import highcloud.IP001_PROJECT.domain.MemberInfo;
import highcloud.IP001_PROJECT.mapper.memberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {
    private memberMapper mapper;

    @Autowired
    public MemberRepository(memberMapper mapper){
        this.mapper = mapper;
    }

    public int putMember(Member member){
           return mapper.putMember(member.getId(), member.getName(),member.getPwd(), member.getEmail(),
                member.getPhone(), member.getAddr());
    }

    public Member getMember(String id){
        return mapper.getMember(id);
    }

    public List<Member> getMembers(){
        return mapper.getMembers();
    }

    public int update(Member member){
        return mapper.update(member.getId(), member.getName(),member.getPwd(), member.getEmail(),
                member.getPhone(), member.getAddr());
    }

    public int delete(String who){
        return mapper.delete((who));
    }

    public List<MemberInfo> getMemInfo(){
        return mapper.getMemInfo();
    }
    public List<MemberInfo> getNotbuy(){return mapper.getNotbuy();}
}
