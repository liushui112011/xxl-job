package com.xxl.job.admin.controller.bs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xxl.job.admin.controller.annotation.PermissionLimit;
import com.xxl.job.admin.core.exception.XxlJobException;
import com.xxl.job.admin.core.model.XxlJobGroup;
import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.admin.core.model.XxlJobUser;
import com.xxl.job.admin.core.route.ExecutorRouteStrategyEnum;
import com.xxl.job.admin.core.thread.JobTriggerPoolHelper;
import com.xxl.job.admin.core.trigger.TriggerTypeEnum;
import com.xxl.job.admin.core.util.I18nUtil;
import com.xxl.job.admin.dao.XxlJobGroupDao;
import com.xxl.job.admin.service.LoginService;
import com.xxl.job.admin.service.XxlJobService;
import com.xxl.job.core.biz.model.ReturnJson;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.enums.ExecutorBlockStrategyEnum;
import com.xxl.job.core.glue.GlueTypeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * index controller
 * @author xuxueli 2015-12-19 16:13:16
 */
@RestController
@RequestMapping("/job")
public class BsJobInfoController {

	@Resource
	private XxlJobGroupDao xxlJobGroupDao;
	@Resource
	private XxlJobService xxlJobService;

	@PermissionLimit(limit = false)
	@RequestMapping("/addJob")
	@ResponseBody
	public JSONObject addJob(@RequestBody JSONObject jobInfo) {
		return xxlJobService.addJob(jobInfo);
	}

	@RequestMapping("/triggerJob")
	@ResponseBody
	@PermissionLimit(limit = false)
	public JSONObject triggerJob(@RequestBody  JSONObject jobInfo ) {
		String jobId = jobInfo.getString("jobID");
		String params = jobInfo.getString("params");
		// force cover job param

		JobTriggerPoolHelper.trigger(Integer.parseInt(jobId), TriggerTypeEnum.MANUAL, -1, null, params);
		return new ReturnJson(ReturnJson.SUCCESS_CODE,null).toJson();
	}

	@RequestMapping("/start")
	@ResponseBody
	@PermissionLimit(limit = false)
	public ReturnT<String> start(@RequestBody JSONObject jobID) {
		return xxlJobService.start(Integer.parseInt(jobID.getString("jobID")));

	}

	@RequestMapping("/stop")
	@ResponseBody
	@PermissionLimit(limit = false)
	public ReturnT<String> pause(@RequestBody JSONObject jobID) {
		return xxlJobService.stop(Integer.parseInt(jobID.getString("jobID")));
	}
}
