package cn.hiber.sec.entity;

import cn.hiber.core.entity.BaseEntity;
import lombok.Data;

@Data
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
