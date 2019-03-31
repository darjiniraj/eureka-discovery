package in.niraj.usermicroservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * created by niraj on Mar, 2019
 */
@FeignClient(name = "${service.case.management.serviceId}")
public interface CaseManagementService {

    @GetMapping("greetings")
    String getPort();

    @GetMapping("search/{caseId}")
    String searchCase(@PathVariable String caseId);
}
