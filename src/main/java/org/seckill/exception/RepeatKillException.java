package org.seckill.exception;

/**
 * @date 2019/3/29 13:08
 * 重复秒杀异常(运行期异常)
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
