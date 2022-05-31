package highcloud.IP001_PROJECT.controller;
import highcloud.IP001_PROJECT.domain.Member;
import highcloud.IP001_PROJECT.mapper.memberMapper;
import highcloud.IP001_PROJECT.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class memberController {
    private memberMapper mapper;
    private MemberService memberService;

    public memberController(memberMapper map, MemberService service){
        mapper = map;
        memberService = service;
    }

    @GetMapping("/sign_up")
    public String signUp_get() {
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String signUp(@ModelAttribute Member member, HttpServletResponse resp) throws IOException {
        System.out.println(member.getName());
        boolean res = memberService.join(member);
        if(!res){
            resp.getWriter().print("<script>alert('The ID that already exists!!');</script>");
            resp.getWriter().print("<script>location.href='/sign_up';</script>");
        }
        else{
            resp.getWriter().print("<script>alert('Hi "+ member.getId() +"!');</script>");
            resp.getWriter().print("<script>location.href='/';</script>");
        }
        // 중복확인후 db에 저장
        return "sign_in";
    }

    @PostMapping("/sign_in")
    public String signIn(HttpServletRequest req) {
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        System.out.println(id + "?" + pwd);

        boolean is = memberService.check(id,pwd);

        if(is){
            HttpSession session = req.getSession();
            session.setAttribute("memId", id);
            // 로그인 확인후 맞으면
            return "redirect:/main";
        }
        else return "redirect:/";

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req){
        HttpSession session = req.getSession();
        System.out.println(session.getAttribute("memId"));
        session.invalidate();
        return "redirect:/";
    }
}
