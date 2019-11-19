package cn.hiber.sec.shiro;

import cn.hiber.core.entity.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hiber
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HiberPrincipal implements Identifiable<Long> {

    private Long id;
    private String username;
}
