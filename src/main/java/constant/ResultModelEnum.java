package constant;

import utils.CheckUtils;

/**
 * @description:
 * @author: fengzhihang
 * @create: 2019-08-15 16:47
 **/
public enum ResultModelEnum {

    // 成功
    SUCCESS(ResultCodeConstant.SUCCESS_CODE, ResultCodeConstant.SUCCESS_MESSAGE),

    // 失败
    FAIL(ResultCodeConstant.FAIL_CODE, ResultCodeConstant.FAIL_MESSAGE),

    // 参数有误
    PARAMETER_ERROR(ResultCodeConstant.PARAMETER_ERROR_CODE, ResultCodeConstant.PARAMETER_ERROR_MESSAGE),

    ALREADYSUB_ERROR(ResultCodeConstant.ERROR_ALREADY_SUB_CODE, ResultCodeConstant.ERROR_ALREADY_SUB_MESSAGE);

    private int code;

    private String message;

    ResultModelEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ResultModelEnum getEnumByCode(int code){
        for(ResultModelEnum resultModelEnum : ResultModelEnum.values()){
            if(code == resultModelEnum.code){
                return resultModelEnum;
            }
        }
        return FAIL;
    }

}