package highcloud.IP001_PROJECT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String enter(){
        return "sign_in";
    }
}
