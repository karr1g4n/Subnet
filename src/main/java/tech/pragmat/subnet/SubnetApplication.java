package tech.pragmat.subnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SubnetApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubnetApplication.class, args);
    }

}
