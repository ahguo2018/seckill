package org.seckill.exception;

/**
 * @date 2019/3/29 13:15
 * 秒杀相关业务异常
 */
public class SeckillException extends RuntimeException{

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
