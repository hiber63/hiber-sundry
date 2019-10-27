package cn.hiber.core.service;

import cn.hiber.core.entity.StringEntity;
import cn.hiber.core.repository.StringRepository;

/**
 * @author hiber
 */
public class StringServiceImpl<T extends StringEntity,R extends StringRepository<T>> extends BaseServiceImpl<String,T,R> implements StringService<T,R>  {

}
