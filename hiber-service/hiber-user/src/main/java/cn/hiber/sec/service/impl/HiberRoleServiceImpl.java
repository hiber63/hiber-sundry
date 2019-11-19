package cn.hiber.sec.service.impl;

import cn.hiber.core.service.LongServiceImpl;
import cn.hiber.sec.entity.HiberRole;
import cn.hiber.sec.repository.HiberRoleRepository;
import cn.hiber.sec.service.HiberRoleService;
import org.springframework.stereotype.Service;

/**
 * @author hiber
 */
@Service
public class HiberRoleServiceImpl extends LongServiceImpl<HiberRole, HiberRoleRepository> implements HiberRoleService {



}
