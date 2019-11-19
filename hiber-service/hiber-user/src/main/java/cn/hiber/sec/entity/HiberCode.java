package cn.hiber.sec.entity;

import cn.hiber.core.entity.LongEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author hiber
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "hiber_sec_code")
public class HiberCode extends LongEntity {

    private String code;

    private String name;

    private String remark;


}
