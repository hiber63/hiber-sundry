package cn.hiber.core.service;

import cn.hiber.core.entity.LongEntity;
import cn.hiber.core.repository.LongRepository;

/**
 * @author hiber
 */
public interface LongService<T extends LongEntity,R extends LongRepository<T>> extends BaseService<Long,T,R>{

}
