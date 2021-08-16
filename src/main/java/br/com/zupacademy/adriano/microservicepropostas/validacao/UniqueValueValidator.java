package br.com.zupacademy.adriano.microservicepropostas.validacao;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String campos;
    private Class<?> dominio;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueValue param) {
        campos = param.fieldName();
        dominio = param.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("select c from "+dominio.getName()+" c where c."+campos+"=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        Assert.state(list.size() <= 1, "Foi encontrado mais de um "+dominio+" com o atributo "+campos+" = "+value);
        return list.isEmpty();
    }
}
