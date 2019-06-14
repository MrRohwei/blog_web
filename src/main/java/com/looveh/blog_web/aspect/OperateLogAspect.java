//package com.looveh.blog_web.aspect;
//
//import com.alibaba.fastjson.JSONObject;
//import com.looveh.blog_web.annotation.OperateLog;
//import com.looveh.blog_web.entity.BlogLogs;
//import com.looveh.blog_web.response.Response;
//import com.looveh.blog_web.service.BlogLogService;
//import com.looveh.blog_web.utils.IPUtil;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Method;
//
///**
// * Author：looveh
// * Date：2019/5/21
// * Desc: 日志漆面
// */
//@Aspect
//@Component
//public class OperateLogAspect {
//
//    private static final String HTTPSERVLETREQUEST = "javax.servlet.http.HttpServletRequest";
//    private static final String HTTPSERVLETRESPONSE = "javax.servlet.http.HttpServletResponse";
//
//    @Autowired
//    BlogLogService blogLogService;
//
//    @Pointcut("@annotation(com.looveh.blog_web.annotation.OperateLog)")
//    public void pointCut() {
//    }
//
//    /**
//     * 环绕通知
//     * TODO 在这里踩了个坑，执行point.proceed之后没有返回结果，前端一直拿不到返回值
//     *
//     * @param point
//     * @return
//     * @throws Throwable
//     */
//    @Around("pointCut()")
//    public Object around(ProceedingJoinPoint point) throws Throwable {
//        long beginTime = System.currentTimeMillis();
//        Response result = (Response) point.proceed();
//        long endTime = System.currentTimeMillis();
//
//        saveLog(point, endTime - beginTime);
//        return result;
//    }
//
//    /**
//     * 保存日志到数据库
//     *
//     * @param point
//     * @param time
//     */
//    private void saveLog(JoinPoint point, long time) {
//        //获取request
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//
//        BlogLogs blogLogs = new BlogLogs();
//        blogLogs.setUserType(getUserType(point));
//        blogLogs.setIp(IPUtil.getIpAddress(request));
//        blogLogs.setDesc(getDesc(point));
//        blogLogs.setParam(getParam(point));
//        blogLogs.setDuration((int) time);
//        blogLogs.setRemark(getValue(point));
//
//        blogLogService.saveLog(blogLogs);
//    }
//
//    private OperateLog getAnnotation(JoinPoint point) {
//        MethodSignature methodSignature = (MethodSignature) point.getSignature();
//        Method method = methodSignature.getMethod();
//        OperateLog annotation = method.getAnnotation(OperateLog.class);
//        return annotation;
//    }
//
//    private String getUserType(JoinPoint point) {
//        return getAnnotation(point).userType();
//    }
//
//    private String getDesc(JoinPoint point) {
//        return getAnnotation(point).desc();
//    }
//
//    private String getValue(JoinPoint point) {
//        return getAnnotation(point).value();
//    }
//
//    private String getParam(JoinPoint point) {
//        MethodSignature methodSignature = (MethodSignature) point.getSignature();
//        Method method = methodSignature.getMethod();
//        Object[] args = point.getArgs();
//        String[] parameters = methodSignature.getParameterNames();
//        Class<?>[] parameterTypes = method.getParameterTypes();
//        JSONObject jsonObject = new JSONObject();
//        for (int i = 0; i < parameters.length; i++) {
//            //跳过request和response
//            if (
//                    HTTPSERVLETREQUEST.equalsIgnoreCase(parameterTypes[i].getName())
//                            || HTTPSERVLETRESPONSE.equalsIgnoreCase(parameterTypes[i].getName())
//            ) {
//                continue;
//            }
//            String paramName = parameters[i];
//            Object paramValue = args[i];
//            jsonObject.put(paramName, paramValue);
//        }
//
//        return jsonObject.toJSONString();
//    }
//}
