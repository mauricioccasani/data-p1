package pe.com.scotiabank.perfilamiento.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.message.ObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.com.scotiabank.perfilamiento.model.entity.Question;
import pe.com.scotiabank.perfilamiento.model.request.QuestionRequest;
import pe.com.scotiabank.perfilamiento.model.response.GenericResponse;

import pe.com.scotiabank.perfilamiento.properties.PropertesExterno;
import pe.com.scotiabank.perfilamiento.service.QuestionServiceInf;


import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionApi {
    @Autowired
    private QuestionServiceInf questionService;
    @Autowired
    private PropertesExterno propExt;
    @GetMapping
    public List<Question>getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @PostMapping
    public ResponseEntity<GenericResponse>  saveQuestion(@RequestBody @Valid QuestionRequest request, BindingResult result){
        GenericResponse response;
        if (result.hasErrors()){
            response= this.validMessage(result);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        response= questionService.saveQuestion(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Question getByIdQuestion(@PathVariable Long id){
        return questionService.getByIdQuestion(id);
    }
    @DeleteMapping("/{id}")
    public GenericResponse deleteQuestion(@PathVariable Long id){


        return this.questionService.deleteQuestion(id);
    }
    /****MESSAGE VALIDATION****/
    private GenericResponse validMessage(BindingResult result) {
        List<Map<String, String>> errrs = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        GenericResponse errorMessage =new GenericResponse();
        errorMessage.setCod(propExt.valorIntNegativo);
        errorMessage.setMsg(errrs);
       return errorMessage;
    }


}
