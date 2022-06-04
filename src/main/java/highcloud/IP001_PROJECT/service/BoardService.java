package highcloud.IP001_PROJECT.service;

import highcloud.IP001_PROJECT.domain.Member;
import highcloud.IP001_PROJECT.domain.answer;
import highcloud.IP001_PROJECT.domain.question;
import highcloud.IP001_PROJECT.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class BoardService {
    private BoardRepository repository;
    public BoardService(BoardRepository repository){
        this.repository = repository;
    }

    public void getQuestions(Model model){
        List<question> qlist = repository.getQuestions();
        model.addAttribute("qlist", qlist);
    }

    public void getQuestion(Model model, int id) {
        model.addAttribute("curQuestion", repository.getQuestion(id));
    }

    public void putQuestion(HttpServletRequest request, HttpSession session){
        String head = request.getParameter("head");
        String body = request.getParameter("body");
        String who =  ((Member)session.getAttribute("member")).getId();
        repository.putQuestion(head, body, who);
    }

    public void getAnswers(int qid, Model model){
        model.addAttribute("alist", repository.getAnswers(qid));
    }

    public answer getAnswer(int aid){
        return repository.getAnswer(aid);
    }

    public void putAnswer(HttpSession session, HttpServletRequest request){
        int qid = Integer.parseInt(request.getParameter("qid"));
        String body = request.getParameter("body");
        String who = ((Member)session.getAttribute("member")).getId();
        repository.putAnswer(qid,body,who);
    }

    public int deleteAnswer(int aid, HttpSession session){
        int qid =  getAnswer(aid).getQuestion();
        if(((Member)session.getAttribute("member")).getId().equals(getAnswer(aid).getWho())){
            repository.deleteAnswer(aid);
            return qid;
        }
        return 0;
    }

    public int deleteQuestion(int qid, HttpSession session){
        Member who = ((Member)session.getAttribute("member"));

        if(who.getId().equals(repository.getQuestion(qid).getWho()) || who.getId().equals("bbs")){
            repository.deleteQuestion(qid);
            return 1;
        }
        return 0;
    }
}
