package io.github.changebooks.web;

import io.github.changebooks.code.base.Check;
import io.github.changebooks.code.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * 规范通用参数
 *
 * @author changebooks@qq.com
 */
public final class BaseRequestFormatter {
    /**
     * 版本号
     */
    public static final int VERSION = 1;

    /**
     * 输入内容编码，input encode
     */
    public static final String IE = StandardCharsets.UTF_8.name();

    /**
     * 输出语种，output language type
     */
    public static final String OL = "ZH-CN";

    /**
     * 输出数据格式，output data type
     */
    public static final String OD = "JSON";

    private BaseRequestFormatter() {
    }

    /**
     * 规范参数
     *
     * @param request {@link BaseRequest} 参数
     */
    public static void format(BaseRequest request) {
        if (request == null) {
            return;
        }

        Integer rawVersion = request.getVersion();
        String rawIe = request.getIe();
        String rawOl = request.getOl();
        String rawOd = request.getOd();

        int version = Optional.ofNullable(rawVersion).orElse(VERSION);
        String ie = cleanProperty(rawIe);
        String ol = cleanProperty(rawOl);
        String od = cleanProperty(rawOd);

        version = Check.isPositive(version) ? version : VERSION;
        ie = Optional.ofNullable(ie).orElse(IE);
        ol = Optional.ofNullable(ol).orElse(OL);
        od = Optional.ofNullable(od).orElse(OD);

        request.setVersion(version);
        request.setIe(ie);
        request.setOl(ol);
        request.setOd(od);
    }

    /**
     * 清理一个参数
     *
     * @param value 清理前的参数值
     * @return 清理后的参数值
     */
    public static String cleanProperty(String value) {
        return StringUtils.toUpper(StringUtils.trimSpace(value));
    }

}
