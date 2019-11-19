package cn.hiber.sec.repository;

import cn.hiber.core.repository.LongRepository;
import cn.hiber.sec.entity.HiberUser;

/**
 * @author hiber
 */
public interface HiberUserRepository extends LongRepository<HiberUser> {

    HiberUser findByUsername(String username);

}
