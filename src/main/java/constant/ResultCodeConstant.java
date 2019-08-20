package constant;

/**
 * @description:
 * @author: fengzhihang
 * @create: 2019-08-15 16:48
 **/
public class ResultCodeConstant {

    /**
     * 成功 code
     */
    public static final int SUCCESS_CODE = 0;

    /**
     * 成功 message
     */
    public static final String SUCCESS_MESSAGE = "成功";

    /**
     * 失败 code
     */
    public static final int FAIL_CODE = 1;

    /**
     * 失败 message
     */
    public static final String FAIL_MESSAGE = "失败";

    public static final int PARAMETER_ERROR_CODE = 2;

    public static final String PARAMETER_ERROR_MESSAGE = "参数有误";

    /**
     * 错误码-已经订阅过股票再次订阅
     */
    public static final int ERROR_ALREADY_SUB_CODE = 3;

    /**
     * 错误信息-已经订阅过股票再次订阅
     */
    public static final String ERROR_ALREADY_SUB_MESSAGE = "已经订阅过 无需再订阅";

    /**
     * 错误码-数据库写失败
     */
    public static final int ERROR_MYBATIS_WRITE_FAIL_CODE = 4;

    /**
     * 错误信息-数据库写记录失败
     */
    public static final String ERROR_MYBATIS_WRITE_FAIL_MESSAGE = "数据库插入记录失败";

    /**
     * 错误码-数据库读失败
     */
    public static final int ERROR_MYBATIS_READ_FAIL_CODE = 5;

    /**
     * 错误信息-数据库读记录失败
     */
    public static final String ERROR_MYBATIS_READ_FAIL_MESSAGE = "数据库更新记录失败";
}