package in.niraj.usermicroservice.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * created by niraj on Mar, 2019
 */

@RestController
public class UserRestClientController {

    Logger logger = LoggerFactory.getLogger(UserRestClientController.class);

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.case.management.serviceId}")
    private String caseManagementServiceId;

    /*not recommended*/
    @GetMapping("/rest-demo")
    public String demoMethodWithRestClient() {
        Application application = eurekaClient.getApplication(caseManagementServiceId);
        /*need to write somelogic to pick node in round robin fasion, as well it must be healthy !! complex*/
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/greetings";
        logger.info("URL {}", url);
        String returnedValue = restTemplate.getForObject(url, String.class);
        logger.info("RESPONSE {}", returnedValue);
        return returnedValue;
    }


}
