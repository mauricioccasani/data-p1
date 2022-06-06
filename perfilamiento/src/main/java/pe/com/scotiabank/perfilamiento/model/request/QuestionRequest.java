package pe.com.scotiabank.perfilamiento.model.request;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.hibernate.annotations.Parent;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
@JsonPropertyOrder({"id", "preg1", "preg2", "preg3", "preg4", "preg5"})
public class QuestionRequest{
    private Long id;
    @NotBlank(message = "Cuestionario 1 es requerido")
    @Pattern(regexp = "[abcd]",message = "Cuestionario 1 permitido a hasta d")

    private String answer1;

    @NotBlank(message = "Cuestionario 2 es requerido")
    @Pattern(regexp = "[abcd]",message = "Cuestionario 2 permitido a hasta d")
    private String answer2;

    @NotBlank(message = "Cuestionario 3 es requerido")
    @Pattern(regexp = "[abcde]",message = "Cuestionario 3 permitido a hasta e")
    private String answer3;

    @NotBlank(message = "Cuestionario 4 es requerido")
    @Pattern(regexp = "[abc]",message = "Cuestionario 4 permitido a hasta c")
    private String answer4;

    @NotBlank(message = "Cuestionario 5 es requerido")
    @Pattern(regexp = "[abc]",message = "Cuestionario 5 permitido a hasta c")
    private String answer5;
}
