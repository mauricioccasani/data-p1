package pe.com.scotiabank.perfilamiento.model.response;

import lombok.Data;
import pe.com.scotiabank.perfilamiento.model.entity.Question;

@Data
public class QuestionResponse extends GenericResponse{
    private Question question;
}
