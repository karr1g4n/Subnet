package tech.pragmat.subnet.service;

import org.springframework.stereotype.Service;
import tech.pragmat.subnet.feign.CountryRegionClient;
import tech.pragmat.subnet.model.SuspectIp;
import tech.pragmat.subnet.repository.IpRepository;

@Service
public class IpService {

    private final IpRepository ipRepository;

    private final CountryRegionClient countryRegionClient;

    public IpService(IpRepository ipRepository, CountryRegionClient countryRegionClient) {
        this.ipRepository = ipRepository;
        this.countryRegionClient = countryRegionClient;
    }

    public SuspectIp addIp(String upperBound, String lowerBound) {
        return ipRepository.save(new SuspectIp(1, upperBound, lowerBound, convertFromIpToInt(upperBound), convertFromIpToInt(lowerBound)));
    }

    public SuspectIp get(String ip) {
        return ipRepository.getSuspectIp(convertFromIpToInt(ip));
    }

    public String getRegion(String ip) {
        if (get(ip) == null) {
            return countryRegionClient.getCountRegion(ip);
        } else {
            return "Ip is blocked";
        }
    }

    private int convertFromIpToInt(String ip) {
        String[] addArray = ip.split("\\.");
        int num = 0;
        for (int i = 0; i < addArray.length; i++) {
            int power = 3 - i;
            num += ((Integer.parseInt(addArray[i]) % 256 * Math.pow(256, power)));
        }
        return num;
    }
}
