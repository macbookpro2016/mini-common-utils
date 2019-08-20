package utils;

import java.util.Collection;
import java.util.List;

/**
 * @description: 一些基本检查方法
 *
 * @author: fengzhihang
 * @create: 2019-07-15 12:38
 **/
public class CheckUtils {

    /**
     * 判断是否为null 或 空字符串
     *
     * @param source
     * @return
     */
    public static boolean isEmpty(String source) {
        if(source == null || source.length() == 0){
            return true;
        }
        return false;
    }

    /**
     * 检查list是否是null 或 空list
     *
     * @param source
     * @return
     */
    public static boolean isEmpty(Collection<?> source) {
        if(source == null || source.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 两个字母+6个数字
     * 例如：sh600000 浦发银行
     *
     * @param stockCode
     * @return
     */
    public static boolean checkStockCodeFormat(String stockCode) {
        if(CheckUtils.isEmpty(stockCode)){
            return false;
        }
        if(stockCode.length() != 8){
            return false;
        }
        boolean result = false;
        try{
            Integer.valueOf(stockCode.substring(2, stockCode.length()));
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}