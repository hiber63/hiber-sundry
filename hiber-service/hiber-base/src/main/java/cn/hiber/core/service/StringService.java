package cn.hiber.core.service;

import cn.hiber.core.entity.StringEntity;
import cn.hiber.core.repository.StringRepository;

/**
 * @author hiber
 */
public interface StringService<T extends StringEntity,R extends StringRepository<T>> extends BaseService<String,T,R>{

}
