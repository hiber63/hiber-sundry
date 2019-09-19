package cn.hiber.core.service.query;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import javax.persistence.criteria.CriteriaBuilder.In;
import java.util.Collection;
import java.util.List;

public class DynamicSpecifications {

	public static <T> Specification<T> bySearchFilter(final Collection<SearchFilter> filters) {
		return new Specification<T>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if(CollectionUtils.isNotEmpty(filters)) {
					List<Predicate> predicates = Lists.newArrayList();
					for(SearchFilter filter : filters) {
						String[] names = StringUtils.split(filter.fieldName, ".");
						Path expression = root.get(names[0]);
						for (int i = 1; i < names.length; i++) {
							expression = expression.get(names[i]);
						}
						switch (filter.operator) {
						case EQ:
							predicates.add(builder.equal(expression, filter.value));
							break;
						case NEQ:
							predicates.add(builder.notEqual(expression, filter.value));
							break;
						case LIKE:
							predicates.add(builder.like(expression, "%" + filter.value + "%"));
							break;
						case GT:
							predicates.add(builder.greaterThan(expression, (Comparable) filter.value));
							break;
						case LT:
							predicates.add(builder.lessThan(expression, (Comparable) filter.value));
							break;
						case GTE:
							predicates.add(builder.greaterThanOrEqualTo(expression, (Comparable) filter.value));
							break;
						case LTE:
							predicates.add(builder.lessThanOrEqualTo(expression, (Comparable) filter.value));
							break;
						case IN:
							String[] values = StringUtils.split(filter.value.toString(), ",");
							In in = builder.in(expression);
							for (String string : values) {
								in.value(string);
							}
							predicates.add(in);
							break;
						}
					}
					//TODO or/and
					if (!predicates.isEmpty()) {
						return builder.and(predicates.toArray(new Predicate[predicates.size()]));
					}
				}
				return builder.conjunction();
			}
		};
	}
}
