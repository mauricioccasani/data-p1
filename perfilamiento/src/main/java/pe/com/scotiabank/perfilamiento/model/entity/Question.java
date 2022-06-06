package pe.com.scotiabank.perfilamiento.model.entity;

import lombok.Data;


import javax.persistence.*;



@Data
@Entity
@Table(name = "Questions")
public class Question {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String preg1;

    private String preg2;

    private String preg3;

    private String preg4;

    private String preg5;


}
