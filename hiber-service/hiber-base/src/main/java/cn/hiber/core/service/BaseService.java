package cn.hiber.core.service;

import cn.hiber.core.entity.BaseEntity;
import cn.hiber.core.repository.BaseRepository;
import cn.hiber.core.service.query.PageQueryVo;
import cn.hiber.core.service.query.SearchFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author hiber
 */
public interface BaseService<ID extends Serializable,T extends BaseEntity, R extends BaseRepository<T, ID>> {
	
	//单个保存
	T save(T entity);
	
	//批量保存
	void saveInBatchs(Collection<T> entities);
	
	//单个删除
	void delete(ID id);
	
	//批量删除
	void deleteInBatchs(Collection<ID> ids);
	
	//根据主键查询
	T findById(ID id);
	
	//根据主键查询
	List<T> findByIds(Collection<ID> ids);
	
	//带条件查询
	List<T> find(List<SearchFilter> filters);
	
	//带条件分页查询
	Page<T> pageQuerySimple(List<SearchFilter> filters, Pageable pageable);
	
	//抽离页面复合查询条件转化SearchFilter过程，封装PageQueryVo来提供统一接口
	Page<T> pageQuery(PageQueryVo pageQueryVo, Pageable pageable);
	
}
