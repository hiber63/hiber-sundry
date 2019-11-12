package cn.hiber.sec.service.impl;

import cn.hiber.core.service.StringServiceImpl;
import cn.hiber.sec.entity.HiberUser;
import cn.hiber.sec.repository.HiberUserRepository;
import cn.hiber.sec.service.HiberUserService;
import org.springframework.stereotype.Service;

/**
 * @author hiber
 */
@Service
public class HiberUserServiceImpl extends StringServiceImpl<HiberUser, HiberUserRepository> implements HiberUserService {


}
