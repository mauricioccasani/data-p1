package pe.com.scotiabank.question.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.scotiabank.question.model.entity.Question;
import pe.com.scotiabank.question.repository.QuestionRepository;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionServiceInf{
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public List<Question> getAllQuestion() {
        return this.questionRepository.findAll();
    }
}
