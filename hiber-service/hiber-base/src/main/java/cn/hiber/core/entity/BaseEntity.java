package cn.hiber.core.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体基类,结合新版本Spring Data提供的审计功能
 * //TODO 创建人以及最后更新人，待认证体系接入后补充
 * @author hiber
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class BaseEntity implements Identifiable,Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "gene-uuid")
    @GenericGenerator(name = "gene-uuid", strategy = "uuid")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;
    //    @CreatedBy
    @Column(name = "CREATE_ID", length = 32)
    private String createUserId;
    @CreatedDate
    @Column(name = "CREATE_DATE", nullable = false)
    private Date createDate;
    //    @LastModifiedBy
    @Column(name = "UPDATE_ID", length = 32)
    private String updateUserId;
    @LastModifiedDate
    @Column(name = "UPDATE_DATE", nullable = false)
    private Date updateDate;
}
