package in.niraj.eurekaclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.util.StringUtils.*;

/**
 * created by niraj on Mar, 2019
 */

@RestController
public class HelloController {

    @Autowired
    private Environment environment;

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    private static Map<String, String> caseMap = new HashMap<>();

    static {
        caseMap.put("1", "case-1");
        caseMap.put("2", "case-2");
        caseMap.put("3", "case-3");
    }

    @GetMapping("greetings")
    public String greetings() {
        return "value returned from port -> " + Integer.parseInt(environment.getProperty("local.server.port"));
    }

    @GetMapping("/search/{caseId}")
    public String searchByCaseId(@PathVariable String caseId) {
        logger.info(" ----- Search Request received for caseId {} -----", caseId);
        String caseName = caseMap.get(caseId);
        if (isEmpty(caseName))
            return "No Case found for " + caseId;
        else
            return caseName;
    }
}
