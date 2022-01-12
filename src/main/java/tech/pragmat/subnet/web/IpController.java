package tech.pragmat.subnet.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.pragmat.subnet.model.SuspectIp;
import tech.pragmat.subnet.service.IpService;

import java.net.UnknownHostException;

@RestController
@RequestMapping("/ip")
public class IpController {

    private final IpService ipService;

    public IpController(IpService ipService) {
        this.ipService = ipService;
    }

    @GetMapping()
    public SuspectIp add(@RequestParam String startLimit, String endLimit) throws UnknownHostException {
        return null;
    }
}
