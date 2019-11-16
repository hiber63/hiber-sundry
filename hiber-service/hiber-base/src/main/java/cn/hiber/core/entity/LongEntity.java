package cn.hiber.core.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author hiber
 */
@Data
@MappedSuperclass
public class LongEntity extends BaseEntity<Long> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
}
