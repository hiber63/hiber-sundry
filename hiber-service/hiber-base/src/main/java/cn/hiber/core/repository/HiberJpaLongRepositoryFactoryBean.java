package cn.hiber.core.repository;

import cn.hiber.core.entity.BaseEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * @author hiber
 */
public class HiberJpaLongRepositoryFactoryBean extends JpaRepositoryFactoryBean<BaseRepository<BaseEntity, Serializable>, BaseEntity, Serializable> {

	public HiberJpaLongRepositoryFactoryBean(Class<? extends BaseRepository<BaseEntity, Serializable>> repositoryInterface) {
		super(repositoryInterface);
	}

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new HiberJpaLongRepositoryFactory(entityManager);
	}


	
}
