package com.lzy.common.entity.http;

import lombok.*;

/**
 * HttpRequestEntity类用于封装HTTP请求的相关信息
 * 主要包括API类型和请求数据
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HttpRequestEntity {
    private String apiType; // API类型
    private String data; // 数据
}
