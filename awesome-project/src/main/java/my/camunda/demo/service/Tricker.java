package my.camunda.demo.service;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class Tricker implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        throw new BpmnError("Пароль от wi-fi изменен; Печеньки залиты кефиром; Кофемашина неисправна");
    }
}
