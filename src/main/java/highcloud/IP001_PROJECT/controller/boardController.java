package highcloud.IP001_PROJECT.controller;

import highcloud.IP001_PROJECT.domain.Member;
import highcloud.IP001_PROJECT.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class boardController {

    private BoardService service;

    public boardController(BoardService service){
        this.service = service;
    }

    @GetMapping("/board")
    public String getBoard(Model model){
        service.getQuestions(model);
        return "board";
    }

    @GetMapping("/questionDetail")
    public String getDetail(HttpServletRequest request, Model model){

        int id = Integer.parseInt(request.getParameter("id" ));
        service.getQuestion(model,id);
        service.getAnswers(id,model);
        return "questionDetail";
    }

    @GetMapping("/write")
    public String getWrite(){
        return "write";
    }
    @PostMapping("/write")
    public String writeIn(HttpServletRequest request, HttpSession session){
        service.putQuestion(request,session);
        return "redirect:/board";
    }

    @PostMapping("/addAnswer")
    public String addAnswer(HttpServletRequest request, HttpSession session){
        service.putAnswer(session, request);
        return "redirect:/questionDetail?id="+request.getParameter("qid");
    }

    @GetMapping("/deleteAnswer")
    public String deleteAnswer(HttpServletRequest request, HttpSession session){
        int qid = service.deleteAnswer(Integer.parseInt(request.getParameter("id")),session);
        if(qid==0) return "/main";
        return "redirect:/questionDetail?id="+qid;
    }

    @GetMapping("/deleteQuestion")
    public String deleteQuestion(HttpServletRequest request, HttpSession session){
        int qid = Integer.parseInt(request.getParameter("qid"));
        service.deleteQuestion(qid, session);
        return "/board";
    }
}
