package io.github.changebooks.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重定向
 *
 * @author changebooks@qq.com
 */
public final class Dispatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Dispatcher.class);

    /**
     * Base Uri
     */
    public static final String BASE_URI = "/error";

    /**
     * 无访问权限
     */
    public static final String FORBIDDEN = BASE_URI + "/forbidden";

    /**
     * 页面不存在
     */
    public static final String PAGE_NOT_FOUND = BASE_URI + "/page-not-found";

    /**
     * 请求方式不支持
     */
    public static final String METHOD_NOT_ALLOWED = BASE_URI + "/method-not-allowed";

    /**
     * 系统运行异常
     */
    public static final String SYSTEM_RUN_ERR = BASE_URI + "/system-run-err";

    /**
     * 重定向到“无访问权限”
     *
     * @param request  {@link HttpServletRequest} instance
     * @param response {@link HttpServletResponse} instance
     */
    public static void forwardForbidden(HttpServletRequest request, HttpServletResponse response) {
        try {
            String uri = request.getContextPath() + FORBIDDEN;
            LOGGER.info("Dispatcher forwardForbidden, uri: {}, reqURI: {}", uri, request.getRequestURI());

            request.getRequestDispatcher(uri).forward(request, response);
        } catch (Throwable tr) {
            LOGGER.error("Dispatcher forwardForbidden failed, throwable: ", tr);
        }
    }

    /**
     * 重定向到“页面不存在”
     *
     * @param request  {@link HttpServletRequest} instance
     * @param response {@link HttpServletResponse} instance
     */
    public static void forwardPageNotFound(HttpServletRequest request, HttpServletResponse response) {
        try {
            String uri = request.getContextPath() + PAGE_NOT_FOUND;
            LOGGER.info("Dispatcher forwardPageNotFound, uri: {}, reqURI: {}", uri, request.getRequestURI());

            request.getRequestDispatcher(uri).forward(request, response);
        } catch (Throwable tr) {
            LOGGER.error("Dispatcher forwardPageNotFound failed, throwable: ", tr);
        }
    }

    /**
     * 重定向到“请求方式不支持”
     *
     * @param request  {@link HttpServletRequest} instance
     * @param response {@link HttpServletResponse} instance
     */
    public static void forwardMethodNotAllowed(HttpServletRequest request, HttpServletResponse response) {
        try {
            String uri = request.getContextPath() + METHOD_NOT_ALLOWED;
            LOGGER.info("Dispatcher forwardMethodNotAllowed, uri: {}, reqURI: {}", uri, request.getRequestURI());

            request.getRequestDispatcher(uri).forward(request, response);
        } catch (Throwable tr) {
            LOGGER.error("Dispatcher forwardMethodNotAllowed failed, throwable: ", tr);
        }
    }

    /**
     * 重定向到“系统运行异常”
     *
     * @param request  {@link HttpServletRequest} instance
     * @param response {@link HttpServletResponse} instance
     */
    public static void forwardSystemRunErr(HttpServletRequest request, HttpServletResponse response) {
        try {
            String uri = request.getContextPath() + SYSTEM_RUN_ERR;
            LOGGER.info("Dispatcher forwardSystemRunErr, uri: {}, reqURI: {}", uri, request.getRequestURI());

            request.getRequestDispatcher(uri).forward(request, response);
        } catch (Throwable tr) {
            LOGGER.error("Dispatcher forwardSystemRunErr failed, throwable: ", tr);
        }
    }

}
