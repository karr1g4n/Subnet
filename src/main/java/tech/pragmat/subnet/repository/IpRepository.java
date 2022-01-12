package tech.pragmat.subnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.pragmat.subnet.model.SuspectIp;

@Repository
public interface IpRepository extends JpaRepository<SuspectIp, Integer> {

    SuspectIp getByStartLimit(int id);
}
