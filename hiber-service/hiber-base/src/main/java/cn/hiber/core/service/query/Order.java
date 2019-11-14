package cn.hiber.core.service.query;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;

/**
 * @author hiber
 */
@Data
public class Order {

    private final String desc;
    private final String property;
    
    public Sort.Order transfer2Order() {
        return new Sort.Order(StringUtils.isNotBlank(desc)?Sort.Direction.DESC:Sort.Direction.ASC,property);
    }
    
}
