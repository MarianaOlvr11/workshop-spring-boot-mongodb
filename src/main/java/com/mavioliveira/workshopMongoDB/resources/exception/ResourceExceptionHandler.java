package com.mavioliveira.workshopMongoDB.resources.exception;


import com.mavioliveira.workshopMongoDB.services.exception.ObjectNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // indica que a classe é responsavel por tratar erros nas requisições
public class ResourceExceptionHandler{

    // metodo que trata a exçeção
    @ExceptionHandler(ObjectNotFound.class) // quando ocorrer exceçaõ
    public ResponseEntity<StandardError> objNotFound(ObjectNotFound e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND; // valor notFound 404
        StandardError error = new StandardError(System.currentTimeMillis(),status.value(),"Não Encontrado", e.getMessage(), request.getRequestURI()); // request.getRequestURI pega o caminho

        return ResponseEntity.status(status).body(error); // retorna o status e o corpo do erro
    }
}
