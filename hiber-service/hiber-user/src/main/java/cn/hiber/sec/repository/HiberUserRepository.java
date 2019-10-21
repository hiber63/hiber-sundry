package cn.hiber.sec.repository;

import cn.hiber.core.repository.BaseRepository;
import cn.hiber.sec.entity.HiberUser;

/**
 * @author hiber
 */
public interface HiberUserRepository extends BaseRepository<HiberUser,String> {

    HiberUser findByUsername(String username);

}
