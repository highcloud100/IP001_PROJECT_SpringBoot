package highcloud.IP001_PROJECT.repository;

import highcloud.IP001_PROJECT.domain.answer;
import highcloud.IP001_PROJECT.domain.question;
import highcloud.IP001_PROJECT.mapper.boardMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {
    private boardMapper mapper;
    public BoardRepository(boardMapper mapper){
        this.mapper = mapper;
    }

    public List<question> getQuestions(){
        return mapper.getQuesions();
    }
    public question getQuestion(int id){
        return mapper.getQuestion(id);
    }
//    int putQuestion(){
//        mapper.putQuestion()
//    }

    public int putQuestion(String head, String body, String who){
        return mapper.putQuestion(head,body, who);
    }

    public int putAnswer(int qid, String body, String who){
        return mapper.putAnswer(qid,body,who);
    }

    public List<answer> getAnswers(int qid){
        return mapper.getAnswers(qid) ;
    }
    public answer getAnswer(int aid){
        return mapper.getAnswer(aid) ;
    }

    public int deleteAnswer(int aid){
        return mapper.delAnswer(aid);
    }

    public int deleteQuestion(int qid){
        mapper.delAnswers(qid);
        return mapper.delQuestion(qid);
    }
}
