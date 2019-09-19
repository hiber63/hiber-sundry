package cn.hiber.core.service;

import cn.hiber.core.repository.BaseRepository;
import cn.hiber.core.service.query.PageQueryVo;
import cn.hiber.core.service.query.SearchFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

/**
 * @author hiber
 */
public interface BaseService<T, R extends BaseRepository<T, String>> {
	
	//单个保存
	T save(T entity);
	
	//批量保存
	void saveInBatchs(Collection<T> entities);
	
	//单个删除
	void delete(String id);
	
	//批量删除
	void deleteInBatchs(Collection<String> ids);
	
	//根据主键查询
	T findById(String id);
	
	//根据主键查询
	List<T> findByIds(Collection<String> ids);
	
	//带条件查询
	List<T> find(List<SearchFilter> filters);
	
	//带条件分页查询
	Page<T> pageQuerySimple(List<SearchFilter> filters, Pageable pageable);
	
	//抽离页面复合查询条件转化SearchFilter过程，封装PageQueryVo来提供统一接口
	Page<T> pageQuery(PageQueryVo pageQueryVo, Pageable pageable);
	
}
