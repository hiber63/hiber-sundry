package cn.hiber.sec.entity;

import cn.hiber.core.entity.StringEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
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
public class HiberUser extends StringEntity {

	@Column(name = "USERNAME",unique = true,nullable = false)
	private String username;
	@Column(name = "PASSWORD",nullable = false)
	@JsonIgnore
	private String password;

	@Column(name = "SALT")
	private String salt;
	@Column(name = "NICKNAME")
	private String nickname;
	@Column(name = "REALNAME")
	private String realname;
	@Column(name = "TEL")
	private String tel;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "ICON")
	private String icon;
	@Column(name = "LOCKED")
	private String locked;

	//user<==>role
}
