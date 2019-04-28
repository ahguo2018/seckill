package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExcution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @date 2019/3/29 19:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() {
        long id = 1000L;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void exportSeckillUrl() {
        long id = 1000L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}",exposer);
        /**
         * exposer=Exposer{
         * exposed=true,
         * md5='212054931f41991b56edfdb667a96064',
         * seckillId=1000,
         * now=0,
         * start=0,
         * end=0}
         */
    }

    @Test
    public void executeSeckill() {
        long id = 1000L;
        long userPhone = 15212244616L;
        String md5 = "212054931f41991b56edfdb667a96064";
        SeckillExcution excution = seckillService.executeSeckill(id,userPhone,md5);
        logger.info("result={}",excution);
        /**
         * result=SeckillExcution{
         * seckillId=1000,
         * state=1,
         * stateInfo='秒杀成功',
         * successKilled=SuccessKilled{seckilId=1000, userPhone=15212244616, state=0, createTime=Fri Mar 29 19:48:30 CST 2019}}
         */
    }

    //集成测试代码完整逻辑,注意可重复执行
    @Test
    public void testSeckillLogic(){
        long id = 1000L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.getExposed()){
            logger.info("exposer={}",exposer);
            long userPhone = 15312244616L;
            String md5 = exposer.getMd5();
            try {
                SeckillExcution excution = seckillService.executeSeckill(id,userPhone,md5);
                logger.info("result={}",excution);
            }catch (RepeatKillException e){
                logger.error(e.getMessage());
            }catch (SeckillCloseException e){
                logger.error(e.getMessage());
            }
        }else {
            logger.warn("exposer={}",exposer);
        }
    }

    @Test
    public void testExecuteSeckillProcedure(){
        long id = 1003L;
        long phone = 13225658719L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.getExposed()){
            String md5 = exposer.getMd5();
            SeckillExcution excution = seckillService.executeSeckillProcedure(id,phone,md5);
            logger.info("state={},stateInfo={}",excution.getState(),excution.getStateInfo());
        }
    }
}