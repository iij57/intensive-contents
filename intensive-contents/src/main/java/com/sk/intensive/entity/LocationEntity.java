package com.sk.intensive.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "LOCATION")
@SequenceGenerator(name="LOCATION_SEQ_GEN", sequenceName="LOCATION_SEQ", initialValue=1, allocationSize=1 )
@Data
public class LocationEntity {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCATION_SEQ_GEN" )
    private Long addrId;

    @Column(name = "JUSO", length = 100)
    private String juso;
    
    @Column(name = "WGS84_X")
    private String wgs84X;

    @Column(name = "WGS84_Y")
    private String wgs84Y;
    
    public Long getAddrId() {
        return addrId;
    }
    
}