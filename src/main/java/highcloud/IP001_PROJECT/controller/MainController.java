package highcloud.IP001_PROJECT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

@Controller
public class MainController {
    @GetMapping("/main")
    public String main(HttpServletRequest req){
        HttpSession session = req.getSession();

        if((String) session.getAttribute("memId")==null){
            return "redirect:/";
        }
        return "main";
    }
}
