package com.fastandroid.lib.json;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * @description 在需要封装JSON解析值的类字段上使用此注解
 * @author 许友爻
 * @date 2014年6月18日 下午1:40:46
 * @version 1.0
 */
@Retention(value = RetentionPolicy.RUNTIME)
public @interface JsonField {
	/**
	 * JSON key的名称(必须指定)
	 * */
   String name();
   /**
    * JSON value的类型(当前字段为集合时，使用本参数指定集合里面的对象的类型)
    * */
   Class<?> type() default Void.class;
}
