package cn.hiber.sec.repository;

import cn.hiber.core.repository.LongRepository;
import cn.hiber.sec.entity.HiberUserRole;

import java.util.List;

/**
 * @author hiber
 */
public interface HiberUserRoleRepository extends LongRepository<HiberUserRole> {
    
    List<HiberUserRole> findHiberUserRolesByUserIdOrderByCdateDesc(Long userId);
    
}
