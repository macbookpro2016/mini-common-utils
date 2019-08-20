package constant;

/**
 * 延迟计算日期前后时间单位枚举
 */
public enum DateDelayUnitEnum {

    YEAR(1, "年"),
    MONTH(2, "月"),
    DAY(3, "日"),
    HOUR(4, "时"),
    MINUTE(5,"分"),
    SECOND(6, "秒");

    private int unit;
    private String unitName;

    DateDelayUnitEnum(int unit, String unitName) {
        this.unit = unit;
        this.unitName = unitName;
    }

}
