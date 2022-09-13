package my.camunda.demo.api;

import org.camunda.bpm.engine.ProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/awesome/api")
public class AwesomeRestController {
    @Autowired
    ProcessEngine engine;

    @GetMapping("/start")
    public String start(@RequestParam("count") int count) {
        engine.getRuntimeService()
                .createProcessInstanceByKey("awesome-project-process")
                .setVariable("deal", "nothing to do")
                .setVariable("count", count)
                .execute();
        return "started!";
    }
}
