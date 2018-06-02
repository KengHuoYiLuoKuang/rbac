package cn.gson.crm.model.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Log {
    private int logCode;
    private Timestamp logDateTime;
    private String requestUri;
    private String requestMethod;
    private String requestParam;
    private String responseContent;
    private Double spendTime;

    @Id
    @Column(name = "log_code", nullable = false)
    public int getLogCode() {
        return logCode;
    }

    public void setLogCode(int logCode) {
        this.logCode = logCode;
    }

    @Basic
    @Column(name = "log_date_time", nullable = true)
    public Timestamp getLogDateTime() {
        return logDateTime;
    }

    public void setLogDateTime(Timestamp logDateTime) {
        this.logDateTime = logDateTime;
    }

    @Basic
    @Column(name = "request_uri", nullable = true, length = 255)
    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    @Basic
    @Column(name = "request_method", nullable = true, length = 255)
    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    @Basic
    @Column(name = "request_param", nullable = true, length = 255)
    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    @Basic
    @Column(name = "response_content", nullable = true, length = -1)
    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }

    @Basic
    @Column(name = "spend_time", nullable = true, precision = 2)
    public Double getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Double spendTime) {
        this.spendTime = spendTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return logCode == log.logCode &&
                Objects.equals(logDateTime, log.logDateTime) &&
                Objects.equals(requestUri, log.requestUri) &&
                Objects.equals(requestMethod, log.requestMethod) &&
                Objects.equals(requestParam, log.requestParam) &&
                Objects.equals(responseContent, log.responseContent) &&
                Objects.equals(spendTime, log.spendTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(logCode, logDateTime, requestUri, requestMethod, requestParam, responseContent, spendTime);
    }
}
