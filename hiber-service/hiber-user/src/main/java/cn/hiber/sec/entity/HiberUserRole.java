package cn.hiber.sec.entity;

import cn.hiber.core.entity.StringEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author hiber
 */
@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "hiber_sec_user_role")
public class HiberUserRole extends StringEntity {

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private HiberUser user;
    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private HiberRole role;

}
