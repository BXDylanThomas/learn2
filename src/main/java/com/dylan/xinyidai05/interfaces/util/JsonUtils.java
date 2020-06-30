package com.dylan.xinyidai05.interfaces.util;

import com.dylan.xinyidai05.infrastructure.persitence.entity.finace.PaymentDO;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * @author baoxiang
 * @create 2020-06-28 10:07
 */
public class JsonUtils {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象list
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        String json = "{\n" +
//                "        \"makeDate\": \"2020-06-25 16:18:58\",\n" +
//                "        \"modifyDate\": \"2020-06-25 17:56:17\",\n" +
                "        \"operator\": \"operator\",\n" +
                "        \"id\": 2,\n" +
                "        \"payCode\": \"paycode\",\n" +
                "        \"serialNo\": \"serialno\",\n" +
                "        \"type\": \"10\",\n" +
                "        \"channel\": \"cha\",\n" +
                "        \"bankCode\": \"bankcode\",\n" +
                "        \"bankAccNo\": \"bankaccno\",\n" +
                "        \"bankAccName\": \"bankaccname\",\n" +
                "        \"amount\": 1000,\n" +
                "        \"status\": \"sta\",\n" +
                "        \"failReason\": \"failreason\"\n" +
                "    }";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(json);

        PaymentDO paymentDO = objectMapper.readValue(json, PaymentDO.class);
        System.out.println(paymentDO);

        String jsonRes = objectMapper.writeValueAsString(paymentDO);
        System.out.println(jsonRes);


        JsonFactory factory = objectMapper.getFactory();
        JsonParser parser = factory.createParser(json);
        JsonToken nextToken = parser.nextToken();
        int i =0;
        while (i<10) {
            if (JsonToken.FIELD_NAME == nextToken) {
                String key = parser.getCurrentName();
                System.out.println("KEY->"+key);
            }
            nextToken = parser.nextToken();
            if(JsonToken.VALUE_STRING == nextToken){
                String value = parser.getValueAsString();
                System.out.println("VALUE->"+value);
            }

            i++;

        }
    }
}
 