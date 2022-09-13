package my.camunda.demo.guilty;

import org.camunda.bpm.client.ExternalTaskClient;

public class Worker {

    public static void main(String[] args) {
        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000)
                .build();

        client.subscribe("guilties-queue")
                .lockDuration(1000)
                .handler((externalTask, externalTaskService) -> {

                    String deal = (String) externalTask.getVariable("deal");
                    long count = (Long) externalTask.getVariable("count");

                    for (int i = 1; i <= count; i++) {
                        System.out.println(deal + i + " HARDWORKING");
                    }

                    externalTaskService.complete(externalTask);
                })
                .open();
    }

}
