package cn.hiber.core.repository;

import cn.hiber.core.entity.LongEntity;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import javax.persistence.EntityManager;

/**
 * @author hiber
 */
public class LongRepositoryImpl<T extends LongEntity> extends BaseRepositoryImpl<T,Long> implements LongRepository<T> {
    public LongRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    public LongRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager em) {
        super(entityInformation, em);
    }
}
