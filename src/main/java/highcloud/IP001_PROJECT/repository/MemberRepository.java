package highcloud.IP001_PROJECT.repository;

import highcloud.IP001_PROJECT.domain.Member;
import highcloud.IP001_PROJECT.mapper.memberMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    private memberMapper mapper;

    public MemberRepository(memberMapper mapper){
        this.mapper = mapper;
    }

    public int putMember(Member member){
           return mapper.putMember(member.getId(), member.getName(),member.getPwd(), member.getEmail(),
                member.getPhone(), member.getAddr());
    }


}
