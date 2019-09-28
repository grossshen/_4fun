package tech.poorguy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Date 9/28/2019 3:58 PM
 * @Mail 494939649@qq.com
 **/
//used for class or interface
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Scan {
    String scanPackage();
}
