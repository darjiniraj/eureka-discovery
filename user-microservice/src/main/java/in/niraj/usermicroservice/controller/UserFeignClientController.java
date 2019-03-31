package in.niraj.usermicroservice.controller;

import in.niraj.usermicroservice.service.CaseManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by niraj on Mar, 2019
 */
@RestController
public class UserFeignClientController {

    @Autowired
    CaseManagementService caseManagementService;

    @GetMapping("/feign-demo")
    public String getServicePortNumber() {
        return caseManagementService.getPort();
    }


    @GetMapping("/search/{id}")
    public String searchCaseById(@PathVariable String id) {
        return caseManagementService.searchCase(id);
    }
}
