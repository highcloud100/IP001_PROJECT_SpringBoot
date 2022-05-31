package highcloud.IP001_PROJECT.service;

import highcloud.IP001_PROJECT.domain.Member;
import highcloud.IP001_PROJECT.mapper.memberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private memberMapper mapper;

    @Autowired
    public MemberService(memberMapper m){
        mapper = m;
    }

    public boolean check(String id, String pwd){
       Member m = mapper.getMember(id);
       if(m.getId().equals(id) && m.getPwd().equals(pwd)){
           return true;
       }
       else return false;
    }

    public boolean join(Member member) {
        //member db에 중복확인하고 저장

        Member m = mapper.getMember(member.getId());
        if(m!=null){ // 중복
            return false;
        }



        return true;
    }
}
