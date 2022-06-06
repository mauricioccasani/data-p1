package pe.com.scotiabank.perfilamiento.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import pe.com.scotiabank.perfilamiento.model.entity.Question;
import pe.com.scotiabank.perfilamiento.model.request.QuestionRequest;
import pe.com.scotiabank.perfilamiento.model.request.QuestionValue;
import pe.com.scotiabank.perfilamiento.model.response.GenericResponse;

import pe.com.scotiabank.perfilamiento.properties.PropertesExterno;
import pe.com.scotiabank.perfilamiento.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionServiceInf {

    private static final Logger LOG = LoggerFactory.getLogger(QuestionServiceImpl.class);
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private PropertesExterno proExt;


    @Override
    public GenericResponse saveQuestion(QuestionRequest request) {

        Question oQuestion = new Question();
        oQuestion.setPreg1(request.getAnswer1());
        oQuestion.setPreg2(request.getAnswer2());
        oQuestion.setPreg3(request.getAnswer3());
        oQuestion.setPreg4(request.getAnswer4());
        oQuestion.setPreg5(request.getAnswer5());
        GenericResponse response = this.validQuestion(oQuestion);
        LOG.info("Response valid: {}",response);
        if (response.getCod()==proExt.valorCeroInt){
            this.questionRepository.save(oQuestion);
        }
        return response;
    }

    @Override
    public List<Question> getAllQuestion() {
        return this.questionRepository.findAll();
    }

    @Override
    public Question getByIdQuestion(Long id) {
        return this.questionRepository.findById(id).orElse(null);
    }

    @Override
    public GenericResponse deleteQuestion(Long id) {
        GenericResponse response = new GenericResponse();
        if (id != null) {
            this.questionRepository.deleteById(id);
            response.setCod(0);
            response.setMsg("ok");
        } else {
            response.setCod(1);
            response.setMsg("Error al eliminar ");
        }

        return response;
    }


    private GenericResponse validQuestion(Question request) {
        GenericResponse response = new GenericResponse();
        QuestionValue qValue = new QuestionValue();
        qValue.setValorPregunta1(this.pregunta1(request));
        qValue.setValorPregunta2(this.pregunta2(request));
        qValue.setValorPregunta3(this.pregunta3(request));
        qValue.setValorPregunta4(this.pregunta4(request));
        qValue.setValorPregunta5(this.pregunta5(request));
        qValue.setValorFinal(qValue.getValorPregunta1() + qValue.getValorPregunta2() + qValue.getValorPregunta3() + qValue.getValorPregunta4() + qValue.getValorPregunta5());
        LOG.info("Sumatoria valorFinal {}", qValue.getValorFinal());
        if (qValue.getValorFinal() == 45) {
            response.setMsg("Muy conservador");
        } else if (qValue.getValorFinal() >= 50 && qValue.getValorFinal() <= 95) {
            response.setMsg("Conservador");
        } else if (qValue.getValorFinal() >= 100 && qValue.getValorFinal() <= 145) {
            response.setMsg("Moderado");
        } else if (qValue.getValorFinal() >= 150 && qValue.getValorFinal() <= 195) {
            response.setMsg("Proactivo");
        } else if (qValue.getValorFinal() >= 200 && qValue.getValorFinal() <= 260) {
            response.setMsg("Sofisticado");
        }
        LOG.info("Perfil del cliente es: {}", response.getMsg());
        return response;
    }

    private int pregunta1(Question request) {
        int response = proExt.valorCeroInt;
        if (request.getPreg1().equals(proExt.q1ValorA)) {
            response = 5;
        } else if (request.getPreg1().equals(proExt.q1ValorB)) {
            response = 10;
        } else if (request.getPreg1().equals(proExt.q1ValorC)) {
            response = 20;
        } else if (request.getPreg1().equals(proExt.q1ValorD)) {
            response = 30;
        }

        return response;
    }

    private int pregunta2(Question request) {
        int response = proExt.valorCeroInt;
        if (request.getPreg2().equals(proExt.q2ValorA)) {
            response = 10;
        } else if (request.getPreg2().equals(proExt.q2ValorB)) {
            response = 20;
        } else if (request.getPreg2().equals(proExt.q2ValorC)) {
            response = 40;
        } else if (request.getPreg2().equals(proExt.q2ValorD)) {
            response = 70;
        }
        return response;
    }

    private int pregunta3(Question request) {
        int response = proExt.valorCeroInt;
        if (request.getPreg3().equals(proExt.q3ValorA)) {
            response = 10;
        } else if (request.getPreg3().equals(proExt.q3ValorB)) {
            response = 20;
        } else if (request.getPreg3().equals(proExt.q3ValorC)) {
            response = 50;
        } else if (request.getPreg3().equals(proExt.q3ValorD)) {
            response = 70;
        } else if (request.getPreg3().equals(proExt.q3ValorE)) {
            response = 100;
        }
        return response;
    }

    private int pregunta4(Question request) {
        int response = proExt.valorCeroInt;
        if (request.getPreg4().equals(proExt.q4ValorA)) {
            response = 10;
        } else if (request.getPreg4().equals(proExt.q4ValorB)) {
            response = 20;
        } else if (request.getPreg4().equals(proExt.q4ValorC)) {
            response = 30;
        }
        return response;
    }

    private int pregunta5(Question request) {
        int response = proExt.valorCeroInt;
        if (request.getPreg5().equals(proExt.q5ValorA)) {
            response = 30;
        } else if (request.getPreg5().equals(proExt.q5ValorB)) {
            response = 20;
        } else if (request.getPreg5().equals(proExt.q5ValorC)) {
            response = 10;
        }
        return response;
    }

}
