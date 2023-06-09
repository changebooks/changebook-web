package io.github.changebooks.web;

import io.github.changebooks.code.util.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.Example;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 通过默认的方法，或重写的子方法，创建实例
 *
 * @author changebooks@qq.com
 */
public class DocketSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocketSupport.class);

    /**
     * 文档类型
     */
    private static final DocumentationType DOC_TYPE = DocumentationType.SWAGGER_2;

    /**
     * 默认配置
     */
    private static final boolean DEFAULT_ENABLE = false;

    /**
     * 接口文档
     *
     * @param docketProperties {@link DocketProperties} 配置
     * @return {@link Docket} 实例
     */
    public Docket docket(DocketProperties docketProperties) {
        Boolean rawEnable = docketProperties.getEnable();
        boolean enable = Optional.ofNullable(rawEnable).orElse(defaultEnable());

        ApiInfo apiInfo = apiInfo(docketProperties);
        List<RequestParameter> requestParameters = requestParameters(docketProperties);

        LOGGER.info("DocketSupport docket, enable: {}", enable);
        return new Docket(DOC_TYPE).
                enable(enable).
                select().
                apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).
                paths(PathSelectors.any()).
                build().
                apiInfo(apiInfo).
                globalRequestParameters(requestParameters);
    }

    /**
     * 接口信息
     *
     * @param docketProperties {@link DocketProperties} 配置
     * @return {@link ApiInfo} 实例
     */
    public ApiInfo apiInfo(DocketProperties docketProperties) {
        String rawTitle = docketProperties.getTitle();
        String rawDescription = docketProperties.getDescription();
        String rawVersion = docketProperties.getVersion();
        DocketProperties.Contact rawContact = docketProperties.getContact();
        String rawLicense = docketProperties.getLicense();

        String title = cleanProperty(rawTitle);
        String description = cleanProperty(rawDescription);
        String version = cleanProperty(rawVersion);
        Contact contact = contact(rawContact);
        String license = cleanProperty(rawLicense);

        LOGGER.info("DocketSupport apiInfo, title: {}, description: {}, version: {}, license: {}",
                title, description, version, license);
        return new ApiInfoBuilder().
                title(title).
                description(description).
                version(version).
                contact(contact).
                license(license).
                build();
    }

    /**
     * 参数列表
     *
     * @param docketProperties {@link DocketProperties} 配置
     * @return {@link RequestParameter} 实例列表
     */
    public List<RequestParameter> requestParameters(DocketProperties docketProperties) {
        DocketProperties.Token rawToken = docketProperties.getToken();
        RequestParameter tokenParameter = tokenParameter(rawToken);

        List<RequestParameter> requestParameters = new ArrayList<>();
        requestParameters.add(tokenParameter);

        return requestParameters;
    }

    /**
     * 联系人
     *
     * @param contact {@link DocketProperties.Contact} 配置
     * @return {@link Contact} 实例
     */
    public Contact contact(DocketProperties.Contact contact) {
        contact = Optional.ofNullable(contact).orElse(defaultContact());

        String rawName = contact.getName();
        String rawUrl = contact.getUrl();
        String rawEmail = contact.getEmail();

        String name = cleanProperty(rawName);
        String url = cleanProperty(rawUrl);
        String email = cleanProperty(rawEmail);

        LOGGER.info("DocketSupport contact, name: {}, url: {}, email: {}",
                name, url, email);
        return new Contact(name, url, email);
    }

    /**
     * 访问令牌
     *
     * @param token {@link DocketProperties.Token} 配置
     * @return {@link RequestParameter} 实例
     */
    public RequestParameter tokenParameter(DocketProperties.Token token) {
        token = Optional.ofNullable(token).orElse(defaultToken());

        String rawName = token.getName();
        String rawDescription = token.getDescription();
        String rawExample = token.getExample();

        String name = cleanProperty(rawName);
        String description = cleanProperty(rawDescription);
        String example = cleanProperty(rawExample);

        LOGGER.info("DocketSupport tokenParameter, name: {}, description: {}, example: {}",
                name, description, example);
        return new RequestParameterBuilder().
                name(name).
                description(description).
                example(defaultExample(example)).
                in(ParameterType.HEADER).
                query(sps -> sps.model(ms -> ms.scalarModel(ScalarType.STRING))).
                required(false).
                build();
    }

    /**
     * 默认的例子
     *
     * @param example 描述
     * @return {@link Example} 实例
     */
    public Example defaultExample(String example) {
        return new Example(null, null, null, example, null, null);
    }

    /**
     * 默认的联系人
     *
     * @return {@link DocketProperties.Contact} 配置
     */
    public DocketProperties.Contact defaultContact() {
        return new DocketProperties.Contact();
    }

    /**
     * 默认的访问令牌
     *
     * @return {@link DocketProperties.Token} 配置
     */
    public DocketProperties.Token defaultToken() {
        return new DocketProperties.Token();
    }

    /**
     * 默认启用？
     *
     * @return Enable, or Disable
     * @see #DEFAULT_ENABLE
     */
    public boolean defaultEnable() {
        return DEFAULT_ENABLE;
    }

    /**
     * 清理一个配置
     *
     * @param value 清理前的配置值
     * @return 清理后的配置值
     */
    public String cleanProperty(String value) {
        return StringUtils.trimSpace(value);
    }

}
