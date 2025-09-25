package org.example.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * API响应包装类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    
    private Integer code;
    private String message;
    private T data;
    private Object total;
    private Object page;
    private Object size;
    
    // 构造函数
    public ApiResponse() {}
    
    public ApiResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public ApiResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    
    // 静态方法创建响应
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "操作成功", data);
    }
    
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(200, message, data);
    }
    
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(500, message);
    }
    
    public static <T> ApiResponse<T> error(Integer code, String message) {
        return new ApiResponse<>(code, message);
    }
    
    // Getter和Setter方法
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public Object getTotal() {
        return total;
    }
    
    public void setTotal(Object total) {
        this.total = total;
    }
    
    public Object getPage() {
        return page;
    }
    
    public void setPage(Object page) {
        this.page = page;
    }
    
    public Object getSize() {
        return size;
    }
    
    public void setSize(Object size) {
        this.size = size;
    }
}
