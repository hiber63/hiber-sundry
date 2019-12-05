package cn.hiber.sec.entity;

import cn.hiber.core.entity.LongEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @author hiber
 */
@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "hiber_sec_user_role")
public class HiberUserRole extends LongEntity {

    @Column(name = "USER_ID",nullable = false)
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private HiberRole role;

}
