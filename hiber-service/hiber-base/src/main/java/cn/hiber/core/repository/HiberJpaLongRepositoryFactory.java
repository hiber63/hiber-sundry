package cn.hiber.core.repository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * @author hiber
 */
public class HiberJpaLongRepositoryFactory extends JpaRepositoryFactory {

	public HiberJpaLongRepositoryFactory(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
		return BaseRepositoryImpl.class;
	}


	@Override
	protected JpaRepositoryImplementation<?, ?> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
		JpaEntityInformation<?, Serializable> entityInformation = getEntityInformation(information.getDomainType());
		return new StringRepositoryImpl(entityInformation, entityManager);
	}
}
