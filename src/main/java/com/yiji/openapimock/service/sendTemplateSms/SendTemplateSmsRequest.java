package com.yiji.openapimock.service.sendTemplateSms;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiRequest;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;
import java.util.Map;

/**
 * @author damo@yiji.com
 */
public class SendTemplateSmsRequest extends ApiRequest {

    /**
     * 短信模版名称
     */
    @NotBlank
    @OpenApiField(desc = "短信模版名称",constraint = "商户提供给易极付短信模版，由易极付提供此短信模版的名称",demo = "test")
    private String templateName;

    /**
     * 模板参数
     */
    @NotEmpty
    @OpenApiField(desc = "模板参数",constraint = "模版中可更改的几个地方（占位符）的key和value；其中key为模版中可更改的占位符，value为代替的具体业务值",demo = "{\"name\":\"张三\",\"chapter\":\"123456\"}")
    private Map<String, String> templateParam;

    /**
     * 短信接收列表
     */
    @NotEmpty
    @OpenApiField(desc = "短信接收者列表",constraint = "支持多个接受者，但是只有第一个走高速通道。如果想多个号码都走高速通道请多次请求",demo = "[\"1234321654589\",\"15672103524\"]")
    private List<String> to;

    @NotBlank
    @OpenApiField(desc = "短信模版对应渠道名",constraint = "与易极付约定短信模版时与模版名称同时提供",demo = "openapi")
    private String subCodeName;

    public String getSubCodeName() {
        return subCodeName;
    }

    public void setSubCodeName(String subCodeName) {
        this.subCodeName = subCodeName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Map<String, String> getTemplateParam() {
        return templateParam;
    }

    public void setTemplateParam(Map<String, String> templateParam) {
        this.templateParam = templateParam;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }
}
