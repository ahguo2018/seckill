package org.seckill.entity;

import java.util.Date;

/**
 * @date 2019/3/26 20:29
 * 秒杀活动实体类
 */
public class Seckill {
    /*秒杀活动Id*/
    private long seckillId;
    /*秒杀活动名称*/
    private String name;
    /*库存*/
    private int number;
    /*秒杀活动开启时间*/
    private Date startTime;
    /*秒杀活动结束时间*/
    private Date endTime;
    /*秒杀活动创建时间*/
    private Date createTime;

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Seckill{" +
                "seckillId=" + seckillId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                '}';
    }
}
