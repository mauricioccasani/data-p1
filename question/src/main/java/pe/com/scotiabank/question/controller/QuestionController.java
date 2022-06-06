package pe.com.scotiabank.question.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.scotiabank.question.model.entity.Question;
import pe.com.scotiabank.question.service.QuestionServiceInf;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
    @Autowired
    private QuestionServiceInf serviceInf;
    @GetMapping
    private List<Question>getAll(){
        return  this.serviceInf.getAllQuestion();
    }
}
