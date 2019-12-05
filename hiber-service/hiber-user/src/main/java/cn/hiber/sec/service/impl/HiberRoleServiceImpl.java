package cn.hiber.sec.service.impl;

import cn.hiber.core.service.LongServiceImpl;
import cn.hiber.core.service.query.Operator;
import cn.hiber.core.service.query.PageQueryVo;
import cn.hiber.core.service.query.SearchFilter;
import cn.hiber.sec.entity.HiberRole;
import cn.hiber.sec.repository.HiberRoleRepository;
import cn.hiber.sec.service.HiberRoleService;
import cn.hiber.sec.service.query.RolePageQueryVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hiber
 */
@Service
public class HiberRoleServiceImpl extends LongServiceImpl<HiberRole, HiberRoleRepository> implements HiberRoleService {

    @Override
    protected List<SearchFilter> getFilters(PageQueryVo pageQueryVo) {
        List<SearchFilter> filters = new ArrayList<>();
        if(pageQueryVo != null) {
            RolePageQueryVo vo = (RolePageQueryVo) pageQueryVo;
            String roleName = vo.getRoleName();
            String roleCode = vo.getRoleCode();
            if(StringUtils.isNotBlank(roleName)) {
                filters.add(new SearchFilter("roleName",Operator.LIKE,roleName));
            }
            if(StringUtils.isNotBlank(roleCode)) {
                filters.add(new SearchFilter("roleCode",Operator.LIKE,roleCode));
            }
        }
        return filters;
    }
}
