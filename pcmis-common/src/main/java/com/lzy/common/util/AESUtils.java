package com.lzy.common.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class AESUtils {
    // 密钥 (需要前端和后端保持一致)
    public static final String KEY = "1234567890abcdef";
    // 偏移量
    public static final String VIPARA = "1234567890abcdef";
    // 编码方式
    public static final String CODE_TYPE = "UTF-8";
    // AES：加密方式   CBC：工作模式   PKCS5Padding：填充模式
    private static final String CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";
    private static final String AES = "AES";
    private static final Logger log = LoggerFactory.getLogger(AESUtils.class);

    /**
     * 加密
     *
     * @param contents 待加密内容
     * @param key      密钥
     * @return 加密后的内容
     */
    public static String encode(String contents, String key) {
        if (contents == null || contents.isEmpty()) {
            return contents;
        }
        try {
            /*
             * 新建一个密码编译器的实例，由三部分构成，用"/"分隔，分别代表如下
             * 1. 加密的类型(如AES，DES，RC2等)
             * 2. 模式(AES中包含ECB，CBC，CFB，CTR，CTS等)
             * 3. 补码方式(包含nopadding/PKCS5Padding等等)
             * 依据这三个参数可以创建很多种加密方式
             */
            Cipher cipher = Cipher.getInstance(CBC_PKCS5_PADDING);
            // 偏移量
            IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes(CODE_TYPE));
            byte[] byteContent = contents.getBytes(CODE_TYPE);
            // 使用加密秘钥
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(CODE_TYPE), AES);
            // 初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, zeroIv);
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            // 通过Base64转码返回
            return Base64.encodeBase64String(result);
        } catch (Exception e) {
            log.error("AES加密失败", e);
        }
        return null;
    }

    /**
     * 解密
     *
     * @param content 待解密内容
     * @param key     密钥
     * @return 解密后的内容
     */
    public static String decode(String content, String key) {
        if (content == null || content.isEmpty()) {
            return content;
        }
        try {
            // 实例化
            Cipher cipher = Cipher.getInstance(CBC_PKCS5_PADDING);
            IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes(CODE_TYPE));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(CODE_TYPE), AES);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, zeroIv);
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));
            return new String(result, CODE_TYPE);
        } catch (Exception e) {
            log.error("AES解密失败", e);
        }
        return null;
    }
}
