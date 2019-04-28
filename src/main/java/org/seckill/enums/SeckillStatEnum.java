package org.seckill.enums;

/**
 * @date 2019/3/29 15:01
 * 使用枚举表示常量数据字段
 */
public enum SeckillStatEnum {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_SECKILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改"),
    ;
    private int state;

    private String stateInfo;

    SeckillStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SeckillStatEnum stateOf(int state){
        for (SeckillStatEnum s : values()){
            if(state == s.getState()){
                return s;
            }
        }
        return null;
    }
}
