package tech.pragmat.subnet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "black_list")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuspectIp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "upper_ip")
    private String upperIp;

    @Column(name = "lower_ip")
    private String lowerIp;

    @Column(name = "upper_bound")
    private int upperbound;

    @Column(name = "lower_bound")
    private int lowerBound;

}
