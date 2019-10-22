package cn.hiber.core.service.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchFilter {

	private String fieldName;
	private Operator operator;
	private Object value;
	
}
