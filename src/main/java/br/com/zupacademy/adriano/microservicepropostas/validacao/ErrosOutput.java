package br.com.zupacademy.adriano.microservicepropostas.validacao;

import java.util.ArrayList;
import java.util.List;

public class ErrosOutput {
    private List<String> globalErrorMessages = new ArrayList<>();
    private List<ErroField> fieldErrors = new ArrayList<>();

    public ErrosOutput() {
    }

    public ErrosOutput(String message) {
        this.globalErrorMessages.add(message);
    }

    public void addError(String message) {
        globalErrorMessages.add(message);
    }

    public void addFieldError(String field, String message) {
        ErroField fieldError = new ErroField(field, message);
        fieldErrors.add(fieldError);
    }

    public List<String> getGlobalErrorMessages() {
        return globalErrorMessages;
    }

    public List<ErroField> getErrors() {
        return fieldErrors;
    }

    public int getNumberOfErrors() {
        return globalErrorMessages.size() + fieldErrors.size();
    }
}
