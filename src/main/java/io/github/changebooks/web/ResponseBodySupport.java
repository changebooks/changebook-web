package io.github.changebooks.web;

import io.github.changebooks.code.base.Result;
import io.github.changebooks.code.biz.ResultUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 规范响应结果
 *
 * @author changebooks@qq.com
 */
public class ResponseBodySupport implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Nullable
    @Override
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if (body == null) {
            return null;
        }

        if (body instanceof Result) {
            Result<?> result = (Result<?>) body;
            return processResult(result, returnType, selectedContentType, selectedConverterType, request, response);
        }

        return body;
    }

    /**
     * 规范响应结果
     *
     * @param result                处理前的响应结果
     * @param returnType            结果类型
     * @param selectedContentType   内容类型
     * @param selectedConverterType 转换器类型
     * @param request               当前请求
     * @param response              当前响应
     * @return 处理后的响应结果
     */
    public Object processResult(Result<?> result, MethodParameter returnType, MediaType selectedContentType,
                                Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                ServerHttpRequest request, ServerHttpResponse response) {
        return ResultUtils.dtoToVo(result);
    }

}
