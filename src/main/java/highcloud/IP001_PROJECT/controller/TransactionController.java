package highcloud.IP001_PROJECT.controller;

import highcloud.IP001_PROJECT.domain.Member;
import highcloud.IP001_PROJECT.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TransactionController {
    private TransactionService service;
    public TransactionController(TransactionService s){
        service = s;
    }

    @PostMapping("/buy")
    public String buyLog(HttpServletRequest req, HttpSession session){
        //login 확인 <-필터
//        if( (Member) session.getAttribute("member")== null){
//            return "sign_in";
//        }
        String addr = req.getParameter("addr");
        service.putTran(session, addr,req.getParameter("list"));
        return "redirect:/shop";
    }
}
