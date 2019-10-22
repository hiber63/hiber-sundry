package cn.hiber.sec.entity;

import cn.hiber.core.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "hiber_sec_user")
public class HiberUser extends BaseEntity {

	private String username;
	private String password;
	private String salt;
	private String nickname;
	private String realname;
	private String tel;
	private String email;
	private String icon;
	private String locked;

	//user<==>role
}
