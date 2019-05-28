package com.looveh.blog_web.aspect;

import com.alibaba.fastjson.JSON;
import com.looveh.blog_web.annotation.OperateLog;
import com.looveh.blog_web.dao.BlogLogsMapper;
import com.looveh.blog_web.entity.BlogLogs;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Author：looveh
 * Date：2019/5/21
 * Desc: 日志漆面
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    BlogLogsMapper blogLogsMapper;

    @Pointcut("@annotation(com.looveh.blog_web.annotation.OperateLog)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint point) {
        long beginTime = System.currentTimeMillis();
        try {
            point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();

        saveLog(point, (endTime - beginTime));


    }

    /**
     * 保存日志到数据库
     *
     * @param point
     * @param time
     */
    private void saveLog(ProceedingJoinPoint point, Long time) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        BlogLogs blogLogs = new BlogLogs();

        OperateLog annotation = method.getAnnotation(OperateLog.class);
        if (null != annotation) {
            System.out.println("注解Log的value值为：" + annotation.value());
            blogLogs.setRemark(annotation.value());//备注，保存注解中的value
        }

        StringBuffer info = new StringBuffer();
        Map<String, Object> param = new HashMap<>();

        //类名+方法名
        String className = point.getTarget().getClass().getName();
        String methodName = method.getName();

        //变量类型
        Class<?>[] parameterTypes = method.getParameterTypes();
        //对应参数的值
        Object[] args = point.getArgs();
        //对应参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = u.getParameterNames(method);

        info.append(className);
        info.append(".");
        info.append(methodName);
        info.append("(");
        if (null != parameterTypes && parameterTypes.length > 0) {
            for (int i = 0; i < parameterTypes.length; i++) {
                info.append(parameterTypes[i]);
                info.append(",");

                param.put(parameterNames[i], args[i]);
            }
        }
        info.substring(0, info.length() - 1);
        info.append(")");

//        blogLogs.setClassName(className);
//        blogLogs.setMethodName(methodName);
//        blogLogs.setLevel("INFO");
//        blogLogs.setIpno("");//IP
//        blogLogs.setDuration(time.intValue());
//        blogLogs.setInfo(info.toString());
//        blogLogs.setParam(JSON.toJSONString(param));

        blogLogsMapper.insert(blogLogs);
    }
}
