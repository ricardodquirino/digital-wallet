package br.com.digitalwallet.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@MappedSuperclass
public class BaseModel implements Serializable{

    @Id
    @Getter
    @Setter
    @Column(columnDefinition = "bigint")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

}
