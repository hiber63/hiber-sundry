package cn.hiber.sec.service.query;

import cn.hiber.core.service.query.PageQueryVo;
import lombok.Data;

@Data
public class UserPageQueryVo extends PageQueryVo {

    private String username;
    private String nickname;


}
