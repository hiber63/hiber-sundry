package cn.hiber.core.entity;

import cn.hiber.core.utils.BeanCopyUtils;
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
 * @author hiber
 */
@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity<ID> implements Identifiable<ID>,Serializable {

    private static final long serialVersionUID = 1L;

    //    @CreatedBy
    @Column(name = "cid")
    private ID createId;
    @CreatedDate
    @Column(name = "cdate", nullable = false)
    private Date cdate;
    //    @LastModifiedBy
    @Column(name = "uid")
    private ID updateId;
    @LastModifiedDate
    @Column(name = "udate", nullable = false)
    private Date udate;

    public void copy(BaseEntity e) {
        BeanCopyUtils.beanCopyWithIngore(e, this);
    }

}
