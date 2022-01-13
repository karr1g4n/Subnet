package tech.pragmat.subnet.service;

import org.springframework.stereotype.Service;
import tech.pragmat.subnet.feign.CountryRegionClient;
import tech.pragmat.subnet.model.SuspectIp;
import tech.pragmat.subnet.repository.IpRepository;

import java.net.UnknownHostException;

@Service
public class IpService {

    private final IpRepository ipRepository;

    private final CountryRegionClient countryRegionClient;

    public IpService(IpRepository ipRepository, CountryRegionClient countryRegionClient) {
        this.ipRepository = ipRepository;
        this.countryRegionClient = countryRegionClient;
    }

    public SuspectIp addIp(String upperBound, String lowerBound) throws UnknownHostException {
        return ipRepository.save(new SuspectIp(1,upperBound,lowerBound, convertFromIpToInt(upperBound), convertFromIpToInt(lowerBound)));
    }

    public SuspectIp get(String ip) throws UnknownHostException {
        return ipRepository.getSuspectIp(convertFromIpToInt(ip));
    }

    public String getRegion(String ip) throws UnknownHostException {
        if (get(ip) == null) {
            return countryRegionClient.getCountRegion(ip);
        } else {
            return "Ip is blocked";
        }
    }

    //    private int convertFromIpToInt(String ip) throws UnknownHostException {
    //        InetAddress i = InetAddress.getByName(ip);
    //        return ByteBuffer.wrap(i.getAddress()).getInt();
    //    }

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
