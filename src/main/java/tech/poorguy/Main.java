package tech.poorguy;

import tech.poorguy.annotation.Scan;

/**
 * @Date 9/28/2019 3:58 PM
 * @Mail 494939649@qq.com
 **/
@Scan(scanPackage = "")
public class Main {
    public static void main(String[] args){
        Class<Main> mainClass = Main.class;
        if (mainClass.isAnnotationPresent(Scan.class)) {
            System.out.println("annotated");
        }
    }
}
