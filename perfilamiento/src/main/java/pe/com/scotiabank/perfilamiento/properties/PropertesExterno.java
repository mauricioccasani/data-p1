package pe.com.scotiabank.perfilamiento.properties;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertesExterno {
    @Value("${valor.cero}")
    public int valorCeroInt;
    @Value("${valor.negativo}")
    public int valorIntNegativo;
    @Value("${valor.error}")
    public String valorStringError;

    @Value("${valor.error.msg}")
    public String valorStringErrorMsg;

    @Value("${valor.mensage}")
    public String valorStringOk;

    //Cuestionarios
    @Value("${cuestionario1.valor.a}")
    public String  q1ValorA;
    @Value("${cuestionario1.valor.b}")
    public String  q1ValorB;
    @Value("${cuestionario1.valor.c}")
    public String  q1ValorC;
    @Value("${cuestionario1.valor.d}")
    public String  q1ValorD;

    @Value("${cuestionario2.valor.a}")
    public String  q2ValorA;
    @Value("${cuestionario2.valor.b}")
    public String  q2ValorB;
    @Value("${cuestionario2.valor.c}")
    public String  q2ValorC;
    @Value("${cuestionario2.valor.d}")
    public String  q2ValorD;

    @Value("${cuestionario3.valor.a}")
    public String  q3ValorA;
    @Value("${cuestionario3.valor.b}")
    public String  q3ValorB;
    @Value("${cuestionario3.valor.c}")
    public String  q3ValorC;
    @Value("${cuestionario3.valor.d}")
    public String  q3ValorD;
    @Value("${cuestionario3.valor.e}")
    public String  q3ValorE;

    @Value("${cuestionario4.valor.a}")
    public String  q4ValorA;
    @Value("${cuestionario4.valor.b}")
    public String  q4ValorB;
    @Value("${cuestionario4.valor.c}")
    public String  q4ValorC;


    @Value("${cuestionario5.valor.a}")
    public String  q5ValorA;
    @Value("${cuestionario5.valor.b}")
    public String  q5ValorB;
    @Value("${cuestionario5.valor.c}")
    public String  q5ValorC;


}
