package tech.pragmat.subnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.pragmat.subnet.model.SuspectIp;
import tech.pragmat.subnet.repository.IpRepository;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

@Service
public class IpService {

    private final IpRepository ipRepository;

    @Autowired
    public IpService(IpRepository ipRepository) {
        this.ipRepository = ipRepository;
    }

    public SuspectIp addIp(String ip) throws UnknownHostException {
        int Ip = convertFromIpToInt(ip);
        return ipRepository.save(new SuspectIp(1,Ip));
    }

    public String getByIp(String Ip) throws UnknownHostException {
       convertFromIntToIp(convertFromIpToInt(Ip));
        return null;
    }

    private int convertFromIpToInt(String ip) throws UnknownHostException {
        InetAddress i = InetAddress.getByName(ip);
        return ByteBuffer.wrap(i.getAddress()).getInt();
    }

    private String  convertFromIntToIp(int ip) throws UnknownHostException {
        InetAddress i= InetAddress.getByName(String.valueOf(ip));
        return  i.getHostAddress();
    }

}
