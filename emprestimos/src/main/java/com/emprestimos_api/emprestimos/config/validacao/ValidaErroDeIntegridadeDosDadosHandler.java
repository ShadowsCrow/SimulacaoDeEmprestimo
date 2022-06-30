package com.emprestimos_api.emprestimos.config.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidaErroDeIntegridadeDosDadosHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String validaErroNoRegistroDeClientesComBaseNoQueJaExisteNoBancoERetornaUmaListaDeObjetosErroFormularioDto(DataIntegrityViolationException exception){
        String Errors = exception.getMostSpecificCause().getMessage();

        return Errors;

    }
}
