package cn.hiber.sec.entity;

import cn.hiber.core.entity.LongEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author hiber
 */
@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "hiber_sec_role")
public class HiberRole extends LongEntity {

    @Column(name="ROLE_CODE",nullable = false,unique = true)
    private String roleCode;
    @Column(name="ROLE_NAME",nullable = false,unique = true)
    private String roleName;
    @Column(name="ROLE_DESC")
    private String roleDesc;
    
    @Column(name="ROLE_TYPE")
    private String roleType;
    @Column(name="ROLE_STATUS")
    private String roleStatus;


}
