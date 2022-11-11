package com.guialvesdev.springfoodapi.exceptionhandler;


import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ApiExceptionHandler {

        public static final String MSG_ERRO_GENERICA_USUARIO_FINAL = "ocorreu um erro internado inesperado";

        @ExceptionHandler(Exception.class)
        public ResponseEntity<Object> handleUncaught(Exception ex, WebRequest request){
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            ProblemType problemType = ProblemType.ERRO_SISTEMA;
            String detail = MSG_ERRO_GENERICA_USUARIO_FINAL;

            ex.printStackTrace();

            Problem problem =  createProblemBuilder(status, problemType, , detail)
                    .userMessage(detail);
                    .build();

                    return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);


        }

        @Override
        protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
                                HttpHeaders headers, HttpStatus status, WebRequest request ){
            ProblemType problemType = ProblemType.RECURSO_NAO_ENCONTRADO;
            String detail = String.format("O recurso %s, que voce tentou acessar, nao existe",
                    ex.getRequestURL());

            Problem problem = createProblemBuilder(status, problemType, detail)
                    .userMessage(MSG_ERRO_GENERICA_USUARIO_FINAL)
                    .build():

            return handleExceptionInternal(ex, problem, headers, status, request);
        }


        @Override
        protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders)


















}
