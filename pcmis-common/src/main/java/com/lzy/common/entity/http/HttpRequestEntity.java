package com.lzy.common.entity.http;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HttpRequestEntity {
    private String apiType; // API类型
    private String data; // 数据
}