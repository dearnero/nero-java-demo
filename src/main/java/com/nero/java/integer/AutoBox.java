package com.nero.java.integer;

/**
 * <p>
 * date : 2019-03-11
 * time : 14:56
 * </p>
 *
 * @author Nero
 */
public class AutoBox {


    public static void main(String[] args) {
        long t = System.currentTimeMillis();

        // 注释部分表示不需要装箱操作，避免了在堆中生成大量的对象。提升大量的效率
        //long sum = 0L;
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("total:" + sum);
        System.out.println("processing time: " + (System.currentTimeMillis() - t) + " ms");
    }

}
