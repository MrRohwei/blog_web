package com.looveh.blog_web.aspect;

import com.looveh.blog_web.annotation.OperateLog;
import com.looveh.blog_web.entity.BlogLogs;
import com.looveh.blog_web.service.BlogLogService;
import com.looveh.blog_web.utils.IPUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Author：looveh
 * Date：2019/5/21
 * Desc: 日志漆面
 */
@Aspect
@Component
public class OperateLogAspect {

    @Autowired
    BlogLogService blogLogService;

    @Pointcut("@annotation(com.looveh.blog_web.annotation.OperateLog)")
    public void pointCut() {}

    /**
     * 环绕通知
     * TODO 在这里踩了个坑，执行point.proceed之后没有返回结果，前端一直拿不到返回值
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long endTime = System.currentTimeMillis();

        saveLog(point, endTime-beginTime);
        return result;
    }

    /**
     * 保存日志到数据库
     *
     * @param point
     * @param time
     */
    private void saveLog(JoinPoint point, long time) {
        //获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        BlogLogs blogLogs = new BlogLogs();
        blogLogs.setUserType(getUserType(point));
        blogLogs.setIp(IPUtil.getIpAddress(request));
        blogLogs.setDesc(getDesc(point));
        blogLogs.setParam("");//暂不处理
        blogLogs.setDuration((int) time);
        blogLogs.setRemark(getValue(point));

        blogLogService.saveLog(blogLogs);
    }

    private OperateLog getAnnotation(JoinPoint point){
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        OperateLog annotation = method.getAnnotation(OperateLog.class);
        return annotation;
    }

    private String getUserType(JoinPoint point){
        return getAnnotation(point).userType();
    }

    private String getDesc(JoinPoint point){
        return getAnnotation(point).desc();
    }

    private String getValue(JoinPoint point){
        return getAnnotation(point).value();
    }
}
