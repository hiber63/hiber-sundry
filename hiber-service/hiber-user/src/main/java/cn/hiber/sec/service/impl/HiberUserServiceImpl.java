package cn.hiber.sec.service.impl;

import cn.hiber.core.service.StringServiceImpl;
import cn.hiber.core.service.query.Operator;
import cn.hiber.core.service.query.PageQueryVo;
import cn.hiber.core.service.query.SearchFilter;
import cn.hiber.sec.entity.HiberUser;
import cn.hiber.sec.repository.HiberUserRepository;
import cn.hiber.sec.service.HiberUserService;
import cn.hiber.sec.service.query.UserPageQueryVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hiber
 */
@Service
public class HiberUserServiceImpl extends StringServiceImpl<HiberUser, HiberUserRepository> implements HiberUserService {

    @Override
    protected List<SearchFilter> getFilters(PageQueryVo pageQueryVo) {
        List<SearchFilter> filters = new ArrayList<>();
        if(pageQueryVo != null) {
            UserPageQueryVo vo = (UserPageQueryVo) pageQueryVo;
            String nickname = vo.getNickname();
            String username = vo.getUsername();
            if(StringUtils.isNotBlank(nickname)) {
                filters.add(new SearchFilter("nickname",Operator.LIKE,nickname));
            }
            if(StringUtils.isNotBlank(username)) {
                filters.add(new SearchFilter("username",Operator.LIKE,username));
            }
        }
        return filters;
    }
}
