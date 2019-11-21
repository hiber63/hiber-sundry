package cn.hiber.sec.service.query;

import cn.hiber.core.service.query.PageQueryVo;
import lombok.Data;

/**
 * @author hiber
 */
@Data
public class RolePageQueryVo extends PageQueryVo {
    
    private String roleName;
    
}
