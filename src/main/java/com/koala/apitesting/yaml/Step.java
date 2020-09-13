package com.koala.apitesting.yaml;

public class Step {

    private Object description;
    private Object url;
    private Object type;
    private Object headers;
    private Object body;
    private Object statusCode;
    private Object validations;
    private Object wait;
    private Object dbUrl;
    private Object dbUsername;
    private Object dbPassword;
    private Object dbQuery;

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Object getHeaders() {
        return headers;
    }

    public void setHeaders(Object headers) {
        this.headers = headers;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Object getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Object statusCode) {
        this.statusCode = statusCode;
    }

    public Object getValidations() {
        return validations;
    }

    public void setValidations(Object validations) {
        this.validations = validations;
    }

    public Object getWait() {
        return wait;
    }

    public void setWait(Object wait) {
        this.wait = wait;
    }

    public Object getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(Object dbUrl) {
        this.dbUrl = dbUrl;
    }

    public Object getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(Object dbUsername) {
        this.dbUsername = dbUsername;
    }

    public Object getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(Object dbPassword) {
        this.dbPassword = dbPassword;
    }

    public Object getDbQuery() {
        return dbQuery;
    }

    public void setDbQuery(Object dbQuery) {
        this.dbQuery = dbQuery;
    }
}
