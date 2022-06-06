package pe.com.scotiabank.perfilamiento.model.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@JsonPropertyOrder({"cod", "msg"})
public class GenericResponse {
    private int cod;
    private Object msg;



}
