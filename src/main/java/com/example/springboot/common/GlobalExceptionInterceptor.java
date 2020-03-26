package com.example.springboot.common;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * describe: 全局统一异常拦截器
 *
 * @author 林旭南(linxnsz @ sinosoft.com.cn)
 * @date 2019-12-26 上午 10:50
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionInterceptor {
    @ExceptionHandler(value = Exception.class)
    public Map exceptionHandler(HttpServletRequest request, Exception e) {
        String failMsg = null;
        if (e instanceof MethodArgumentNotValidException) {
            // 拿到参数校验具体异常信息提示
            failMsg = ((MethodArgumentNotValidException) e).getBindingResult().getFieldError().getDefaultMessage();
        }
        // 直接给前端
        Map result = new HashMap();
        result.put("code","1001");
        result.put("message",failMsg);
        return result;
    }
}
