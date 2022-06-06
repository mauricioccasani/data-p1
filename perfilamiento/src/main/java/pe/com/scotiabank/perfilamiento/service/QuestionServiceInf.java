package pe.com.scotiabank.perfilamiento.service;

import pe.com.scotiabank.perfilamiento.model.entity.Question;
import pe.com.scotiabank.perfilamiento.model.request.QuestionRequest;
import pe.com.scotiabank.perfilamiento.model.response.GenericResponse;


import java.util.List;

public interface QuestionServiceInf {
    public GenericResponse saveQuestion(QuestionRequest request);
    public List<Question>getAllQuestion();
    public Question getByIdQuestion(Long id);
    public GenericResponse deleteQuestion(Long id);



}
