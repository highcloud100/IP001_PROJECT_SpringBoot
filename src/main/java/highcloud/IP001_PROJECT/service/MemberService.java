package highcloud.IP001_PROJECT.service;

import highcloud.IP001_PROJECT.domain.Member;
import highcloud.IP001_PROJECT.mapper.memberMapper;
import highcloud.IP001_PROJECT.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class MemberService {

    private MemberRepository repository;
    @Autowired
    public MemberService(MemberRepository repository){
        this.repository = repository;
    }

    public boolean check(String id, String pwd){
       Member m = repository.getMember(id);
       if(m==null) return false;
       if(m.getId().equals(id) && m.getPwd().equals(pwd)){
           return true;
       }
       else return false;
    }

    public boolean login(String id, String pwd, HttpSession session){
        if(check(id,pwd)){
            Member who = repository.getMember(id);
            session.setAttribute("member", who);
            return true;
        }
        return false;
    }

    public boolean join(Member member) {
        //member db에 중복확인하고 저장
        Member m = repository.getMember(member.getId());
        if(m!=null){ // 중복
            return false;
        }
        repository.putMember(member);
        return true;
    }

    public int update(Member member){
        return repository.update(member);

    }
}
