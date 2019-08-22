package exception;

/**
 * @description: 自定义异常
 * dubbo调用过程中的自定义异常应该满足
 * 1.服务提供方不将数据库等错误抛出给消费者
 * 2.如果担心传输效率 则重写 fillInStackTrace 方法不拷贝堆栈信息
 *
 * @author: fengzhihang
 * @create: 2019-07-16 10:52
 **/
public class MiniException extends RuntimeException{

    private int code;

    private String message;

    public MiniException(int code,String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    public MiniException(int code){
        super();
        this.code = code;
    }

    public MiniException() {
        super();
    }

    public MiniException(String message) {
        super(message);
    }

    public MiniException(String message, Throwable cause) {
        super(message, cause);
    }
    public MiniException(Throwable cause) {
        super(cause);
    }

    /**
     * 重写该方法不复制堆栈信息
     * @return
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return null;
    }


}