package tech.pragmat.subnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.pragmat.subnet.model.SuspectIp;

@Repository
public interface IpRepository extends JpaRepository<SuspectIp, Integer> {

    @Query(value = "select * from  black_list u where ?1>=u.upper_bound  and ?1<=u.lower_bound", nativeQuery = true)
    SuspectIp getSuspectIpBy(Integer id);
}
