package cn.hiber.core.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BeanCopyUtils {

    public static <T> void beanCopy(T source, T target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    public static <T> void beanCopyWithIngore(T source, T target, String... ignoreProperties) {
        String[] pns = getNullAndIgnorePropertyNames(source, ignoreProperties);
        BeanUtils.copyProperties(source, target, pns);
    }

    public static String[] getNullAndIgnorePropertyNames(Object source, String... ignoreProperties) {
        Set<String> emptyNames = getNullPropertyNameSet(source);
        for (String s : ignoreProperties) {
            emptyNames.add(s);
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static String[] getNullPropertyNames(Object source) {
        Set<String> emptyNames = getNullPropertyNameSet(source);
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static Set<String> getNullPropertyNameSet(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        return emptyNames;
    }

    public static <E> Map<String, Object> obj2map(E source, String[] ps) {
        Map<String, Object> map = new HashMap<>();
        if (source == null)
            return null;
        if (ps == null || ps.length < 1) {
            return null;
        }
        for (String p : ps) {
            PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(
                    source.getClass(), p);
            if (sourcePd != null && sourcePd.getReadMethod() != null) {
                try {
                    Method readMethod = sourcePd.getReadMethod();
                    if (!Modifier.isPublic(readMethod.getDeclaringClass()
                            .getModifiers())) {
                        readMethod.setAccessible(true);
                    }
                    Object value = readMethod.invoke(source, new Object[0]);
                    map.put(p, value);
                } catch (Exception ex) {
                    throw new RuntimeException("Could not copy properties from source to target", ex);
                }
            }
        }
        return map;
    }

    public static <E> List<Map<String, Object>> objs2mapList(List<E> sources, String[] ps) {
        List<Map<String, Object>> list = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(sources)) {
            for(E obj:sources) {
                list.add(obj2map(obj,ps));
            }
        }
        return list;
    }

}