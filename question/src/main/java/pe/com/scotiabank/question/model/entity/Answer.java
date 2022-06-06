package pe.com.scotiabank.question.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity

public class Answer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String a;
    private String b;
    private String c;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String d;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String e;


}
