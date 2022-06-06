package pe.com.scotiabank.question.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String question;
    @ManyToOne
    @JoinColumn(name="idanswer", nullable=false)
    private Answer answer;
}
