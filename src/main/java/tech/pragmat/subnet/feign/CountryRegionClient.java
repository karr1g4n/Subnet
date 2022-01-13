package tech.pragmat.subnet.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${cr.name}", url = "${cr.url}")
public interface CountryRegionClient {

    @GetMapping("/connectGeo2LiteService/getRegionByIp")
    String getCountRegion(@RequestParam String ip);
}
