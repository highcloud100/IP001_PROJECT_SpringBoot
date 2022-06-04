package highcloud.IP001_PROJECT.controller;

import highcloud.IP001_PROJECT.domain.FileDto;
import highcloud.IP001_PROJECT.domain.Product;
import highcloud.IP001_PROJECT.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AdminController {

    private AdminService service;

    public AdminController(AdminService service){
        this.service = service;
    }

    @GetMapping("/adminU")
    public String getAdminU(HttpSession session, Model model){
        if(service.isAdmin(session)){
            service.setList(session,model);
            return "adminU";
        }else{
            return "redirect:logout";
        }

    }

    @GetMapping("/del")
    public String delU(HttpServletRequest req){
        String who = req.getParameter("who");
        System.out.println("delete" + who);
        service.deleteUser(who);
        return "redirect:/adminU";
    }

    @GetMapping("/adminLP")
    public String getAdminLP(HttpSession session, Model model){
        if(service.isAdmin(session)){
            service.setLPList(model);
            return "adminLP";
        }else{
            return "redirect:logout";
        }
    }
    @GetMapping("/addLpForm")
    public String getLpForm(HttpSession session){
        if(service.isAdmin(session)){
            return "newLPform";
        }else{
            return "redirect:logout";
        }
    }

    @PostMapping("/addNewLp")
    public String addNewLp(@ModelAttribute Product product, @RequestParam MultipartFile upfile, HttpServletRequest req) throws IOException {
        System.out.println("file uploading");
        File newfile = new File(product.getTITLE()+".png");
        upfile.transferTo(newfile);
        service.addNewLp(product);
        return "redirect:/adminLP";
    }

    @GetMapping("/delLp")
    public String delLp(HttpServletRequest request, HttpSession session){
        if(service.isAdmin(session)){
            service.delLp(Integer.parseInt(request.getParameter("what")));
            return "redirect:adminLP";
        }else{
            return "redirect:logout";
        }
    }


}
