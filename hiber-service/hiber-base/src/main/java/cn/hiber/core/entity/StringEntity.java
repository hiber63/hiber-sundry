package cn.hiber.core.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author hiber
 */
@MappedSuperclass
@Data
public abstract class StringEntity extends BaseEntity<String> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "gene-uuid")
    @GenericGenerator(name = "gene-uuid", strategy = "org.hibernate.id.UUIDGenerator" )
    @Column(name = "id", nullable = false, length = 50)
    private String id;
}
