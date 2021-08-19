package br.com.zupacademy.adriano.microservicepropostas.exception;

import br.com.zupacademy.adriano.microservicepropostas.exception.ExceptionResponse;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionValidacao {

    private MessageSource messageSource;

    public ExceptionValidacao(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ExceptionResponse> handle(MethodArgumentNotValidException exception) {
        List<ExceptionResponse> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ExceptionResponse erro = new ExceptionResponse(e.getField(), mensagem);
            dto.add(erro);
        });

        return dto;
    }


    @ExceptionHandler(ExceptionErroApi.class)
    public ResponseEntity<ExceptionDto> handleExceptionErroApi(ExceptionErroApi exception) {
        ExceptionDto error = new ExceptionDto(exception.getField(), exception.getReason());

        return ResponseEntity.status(exception.getHttpStatus()).body(error);
    }





    }



