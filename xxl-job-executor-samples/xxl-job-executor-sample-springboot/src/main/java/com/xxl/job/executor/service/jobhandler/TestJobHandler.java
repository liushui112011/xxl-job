package com.xxl.job.executor.service.jobhandler;/**
 * Created by ${User} on 2019/5/13.
 */

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

/**
 * @author 刘洪洋
 * @create 2019-05-13 下午11:06
 * @desc 测试执行器
 **/
@JobHandler(value = "testJobHandler")
@Component
public class TestJobHandler extends IJobHandler{
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("testLogHandler执行");
        return SUCCESS;
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
