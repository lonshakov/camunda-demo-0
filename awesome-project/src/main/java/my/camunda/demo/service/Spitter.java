package my.camunda.demo.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class Spitter implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String deal = (String) delegateExecution.getVariable("deal");
        long count = (Long) delegateExecution.getVariable("count");

        for (int i = 1; i <= count; i++) {
            System.out.println(deal + i);
        }
    }
}
