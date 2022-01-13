package tech.pragmat.subnet.web;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public IpController(IpService ipService) {
        this.ipService = ipService;
    }

    @PostMapping()
    public SuspectIp add(@RequestParam String upperBound, String lowerBound) throws UnknownHostException {
        return ipService.addIp(upperBound, lowerBound);
    }

    @GetMapping()
    public String getRegion(@RequestParam String ip) throws UnknownHostException {
        return ipService.getRegion(ip);
    }
}
