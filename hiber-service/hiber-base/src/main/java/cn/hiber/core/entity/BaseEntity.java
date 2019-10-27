package cn.hiber.core.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;


/**
 * 实体基类,结合新版本Spring Data提供的审计功能
 * //TODO 创建人以及最后更新人，待认证体系接入后补充
 * @author hiber
 */
@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity<ID> implements Identifiable<ID>,Serializable {

    private static final long serialVersionUID = 1L;

    //    @CreatedBy
    @Column(name = "CREATE_ID", length = 50)
    private String createUserId;
    @CreatedDate
    @Column(name = "CREATE_DATE", nullable = false)
    private Date createDate;
    //    @LastModifiedBy
    @Column(name = "UPDATE_ID", length = 50)
    private String updateUserId;
    @LastModifiedDate
    @Column(name = "UPDATE_DATE", nullable = false)
    private Date updateDate;
}
