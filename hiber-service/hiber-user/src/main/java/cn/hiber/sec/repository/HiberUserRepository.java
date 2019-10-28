package cn.hiber.sec.repository;

import cn.hiber.core.repository.StringRepository;
import cn.hiber.sec.entity.HiberUser;

/**
 * @author hiber
 */
public interface HiberUserRepository extends StringRepository<HiberUser> {

    HiberUser findByUsername(String username);

}
