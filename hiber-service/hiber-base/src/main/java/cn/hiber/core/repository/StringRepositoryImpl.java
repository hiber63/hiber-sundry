package cn.hiber.core.repository;

import cn.hiber.core.entity.StringEntity;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import javax.persistence.EntityManager;

/**
 * @author hiber
 */
public class StringRepositoryImpl<T extends StringEntity> extends BaseRepositoryImpl<T,String> implements StringRepository<T> {
    public StringRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    public StringRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager em) {
        super(entityInformation, em);
    }
}
