package io.github.changebooks.web;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Api文档配置
 *
 * @author changebooks@qq.com
 */
@ConfigurationProperties(prefix = "docket")
public class DocketProperties {
    /**
     * 启用？
     */
    private Boolean enable;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 版本号
     */
    private String version;

    /**
     * 许可证
     */
    private String license;

    /**
     * 联系人
     */
    private final Contact contact = new Contact();

    /**
     * 访问令牌
     */
    private final Token token = new Token();

    /**
     * 联系人
     */
    public static class Contact {
        /**
         * 姓名
         */
        private String name;

        /**
         * 链接
         */
        private String url;

        /**
         * 邮箱
         */
        private String email;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    }

    /**
     * 访问令牌
     */
    public static class Token {
        /**
         * 令牌名
         */
        private String name;

        /**
         * 描述
         */
        private String description;

        /**
         * 默认值
         */
        private String example;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }

    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Contact getContact() {
        return contact;
    }

    public Token getToken() {
        return token;
    }

}
