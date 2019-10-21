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
public class HiberPrincipal implements Identifiable {

    private String id;
    private String username;
}
