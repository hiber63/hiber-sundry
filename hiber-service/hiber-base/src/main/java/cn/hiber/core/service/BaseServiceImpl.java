package cn.hiber.core.service;

import cn.hiber.core.entity.BaseEntity;
import cn.hiber.core.repository.BaseRepository;
import cn.hiber.core.service.query.DynamicSpecifications;
import cn.hiber.core.service.query.PageQueryVo;
import cn.hiber.core.service.query.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author hiber
 */
public class BaseServiceImpl<ID extends Serializable,T extends BaseEntity, R extends BaseRepository<T, ID>>
	implements BaseService<ID, T, R> {

	//protected 子类可以调用
	//Spring后面已经开始支持泛型注入
	@Autowired
	protected R repository;

	@Override
	public T save(T entity) {
		return repository.save(entity);
	}

	@Override
	public void saveInBatchs(Collection<T> entities) {
		repository.saveAll(entities);
	}

	@Override
	public void delete(ID id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteInBatchs(Collection<ID> ids) {
		for(ID id : ids) {
			repository.deleteById(id);
		}
	}

	@Override
	public T findById(ID id) {
		Optional<T> byId = repository.findById(id);
		return byId.isPresent()?byId.get():null;
	}

	@Override
	public List<T> findByIds(Collection<ID> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public List<T> find(List<SearchFilter> filters) {
		return repository.findAll(DynamicSpecifications.bySearchFilter(filters));
	}

	@Override
	public Page<T> pageQuerySimple(List<SearchFilter> filters, Pageable pageable) {
		return repository.findAll(DynamicSpecifications.bySearchFilter(filters), pageable);
	}

	@Override
	public Page<T> pageQuery(PageQueryVo pageQueryVo, Pageable pageable) {
		return repository.findAll(DynamicSpecifications.bySearchFilter(getFilters(pageQueryVo)), pageable);
	}

	//protected,提供子类重写，扩展每个业务模块独立的符合查询条件
	protected List<SearchFilter> getFilters(PageQueryVo pageQueryVo) {
		return null;
	}







}
