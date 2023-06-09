package io.github.changebooks.web;

import io.github.changebooks.code.base.Check;
import io.github.changebooks.code.base.Errors;
import io.github.changebooks.code.base.Result;
import io.github.changebooks.code.biz.BizException;
import io.github.changebooks.code.biz.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一处理异常
 *
 * @author changebooks@qq.com
 */
public class WideExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WideExceptionHandler.class);

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public Result<?> handleBizException(BizException tr, HttpServletRequest request) {
        LOGGER.error("WideExceptionHandler handleBizException, reqURI: {}, throwable: ", request.getRequestURI(), tr);

        return ResultUtils.fromException(tr);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Result<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException tr, HttpServletRequest request) {
        LOGGER.error("WideExceptionHandler handleHttpRequestMethodNotSupportedException, reqURI: {}, throwable: ", request.getRequestURI(), tr);

        return ResultUtils.fromResult(Errors.METHOD_NOT_ALLOWED, tr.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public Result<?> handleIllegalArgumentException(IllegalArgumentException tr, HttpServletRequest request) {
        LOGGER.error("WideExceptionHandler handleIllegalArgumentException, reqURI: {}, throwable: ", request.getRequestURI(), tr);

        return ResultUtils.fromResult(Errors.ARGS_ERR, tr.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException tr, HttpServletRequest request) {
        LOGGER.error("WideExceptionHandler handleMethodArgumentNotValidException, reqURI: {}, throwable: ", request.getRequestURI(), tr);

        FieldError error = tr.getBindingResult().getFieldError();
        String message = Check.nonNull(error) ? error.getDefaultMessage() : Errors.ARGS_ERR.getMessage();

        return ResultUtils.fromResult(Errors.ARGS_ERR, message);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Result<?> handleThrowable(Throwable tr, HttpServletRequest request) {
        LOGGER.error("WideExceptionHandler handleThrowable, reqURI: {}, throwable: ", request.getRequestURI(), tr);

        return ResultUtils.fromThrowable(tr);
    }

}
