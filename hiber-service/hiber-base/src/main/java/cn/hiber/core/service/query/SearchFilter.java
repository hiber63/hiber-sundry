package cn.hiber.core.service.query;

public class SearchFilter {

	public String fieldName;

	public Operator operator;

	public Object value;

	public SearchFilter(String fieldName, Operator operator, Object value) {
		this.fieldName = fieldName;
		this.value = value;
		this.operator = operator;
	}
	
}
