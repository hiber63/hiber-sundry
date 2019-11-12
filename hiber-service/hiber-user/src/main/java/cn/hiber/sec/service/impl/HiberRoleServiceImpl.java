package cn.hiber.sec.service.impl;

import cn.hiber.core.service.StringService;
import cn.hiber.core.service.StringServiceImpl;
import cn.hiber.sec.entity.HiberRole;
import cn.hiber.sec.repository.HiberRoleRepository;
import cn.hiber.sec.service.HiberRoleService;
import org.springframework.stereotype.Service;

/**
 * @author hiber
 */
@Service
public class HiberRoleServiceImpl extends StringServiceImpl<HiberRole, HiberRoleRepository> implements HiberRoleService {



}
