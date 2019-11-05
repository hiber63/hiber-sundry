package cn.hiber.core.service;

import cn.hiber.core.entity.LongEntity;
import cn.hiber.core.repository.LongRepository;

/**
 * @author hiber
 */
public class LongServiceImpl<T extends LongEntity,R extends LongRepository<T>> extends BaseServiceImpl<Long,T,R> implements LongService<T,R>  {

}
