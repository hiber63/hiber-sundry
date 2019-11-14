package cn.hiber.core.service.query;

import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询条件vo
 * @author hiber
 */
@Data
public class PageQueryVo {
    
    private Integer pageNumber = 0;
    
    private Integer pageSize = 10;
    
    private List<Order> orders;

    public PageRequest tranfer2PageRequest() {
        List<Sort.Order> orderList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(orders)) {
            for(Order order:orders) {
                Sort.Order o = order.transfer2Order();
                if(o!=null && StringUtils.isNotBlank(o.getProperty())) {
                    orderList.add(o);
                }
            }
        }
        PageRequest pageable = PageRequest.of(pageNumber,pageSize,Sort.by(orderList));
        return pageable;
    }
    
}
