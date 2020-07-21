package com.dylan.xinyidai05.interfaces.facade.urlmapping;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.handler.WriteHandler;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author baoxiang
 * @create 2020-06-22 9:19
 */
@RestController
public class UrlMappingController {

    private final int fieldNum = 4;

    private List<Class> filterClass = Arrays.asList(HttpServletResponse.class, HttpServletRequest.class, BindingResult.class);

    @GetMapping("/dowloadAllUrlMapping")
    public void dowloadAllUrlMapping(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = getHandleMethod(request);

        Map<String, List<String>> map = new TreeMap<>();
        handlerMethods.forEach((k, v) -> {
            String b = v.getBean().toString();
            List<String> list = map.get(b);
            if (CollectionUtils.isEmpty(list)) {
                list = new ArrayList<>();
            }
            //类描述
            Api api = v.getBeanType().getAnnotation(Api.class);
            list.add(api!=null?api.value():"无");
            //路径地址
            list.add(k.getPatternsCondition().toString());
            //方法描述
            Method method = v.getMethod();
            ApiOperation annotation = method.getAnnotation(ApiOperation.class);
            list.add(annotation != null ? annotation.value() : "无");
            //参数
            String join = Arrays.stream(method.getParameters()).filter(t->!filterClass.contains(t.getType()))
                    .map(x->{
                        Class<?> type = x.getType();
                        if (type == List.class ){
                            String typeName = x.getParameterizedType().getTypeName();
                            typeName =typeName.substring(typeName.lastIndexOf(".")+1,typeName.indexOf(">"));
                            return "List<"+typeName+">";
                        }else if (type == Map.class){
                            String typeName = x.getParameterizedType().getTypeName();
                            String name1 = typeName.substring(typeName.indexOf("<"),typeName.lastIndexOf(","));
                            name1 = name1.substring(name1.lastIndexOf(".")+1);

                            String name2 = typeName.substring(typeName.indexOf(","),typeName.lastIndexOf(">"));
                            name2 = name2.substring(name2.lastIndexOf(".")+1);
                            return "Map<"+name1+","+name2+">";
                        }
                        return type.getSimpleName();
                    }).collect(Collectors.joining(","));
            list.add(join);

            map.put(b, list);
        });

        write(response, map);
    }

    public Map<RequestMappingInfo, HandlerMethod> getHandleMethod(HttpServletRequest request) {
        WebApplicationContext requiredWebApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
        RequestMappingHandlerMapping bean = requiredWebApplicationContext.getBean(RequestMappingHandlerMapping.class);
        return bean.getHandlerMethods();
    }

    public void write(HttpServletResponse response, Map<String, List<String>> map) throws IOException {
        response.setContentType("application/stream+json");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("P05全部调用地址", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        builderExcel(response, map);
    }

    private void builderExcel(HttpServletResponse response, Map<String, List<String>> map) throws IOException {
        ExcelWriter build = EasyExcel.write(response.getOutputStream()).build();
        WriteSheet sheet = EasyExcel.writerSheet("P05")
                .head(createHead())
                .registerWriteHandler(ExcelStyleUtil.globleStyle())
                .registerWriteHandler(createColumnLengthStrategy(map)).build();

        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicInteger mergeStart = new AtomicInteger(0);

        map.forEach((k, v) -> {
            int size = v.size();
            int rowSize = size / fieldNum;
            int currentRow = mergeStart.incrementAndGet();
            int targetRow = rowSize == 1 ? currentRow : mergeStart.addAndGet(rowSize-1);
            WriteTable table = createTable(rowSize, atomicInteger.incrementAndGet(), currentRow, targetRow);
            build.write(doHandleData(k, v), sheet, table);
        });
        build.finish();
    }

    private List<List<String>> doHandleData(String key, List<String> value) {
        List<List<String>> data = new ArrayList<>();

        List<String> temp = new ArrayList<>();
        ;
        for (int i = 0; i < value.size(); i++) {
            if (i == 0) {
                data.add(temp);
                temp.add(key);
            } else if (i % fieldNum == 0) {
                temp = new ArrayList<>();
                data.add(temp);
                temp.add(key);
            }
            temp.add(value.get(i).replaceAll("\\[", "").replaceAll("]", ""));
        }

        return data;
    }

    private WriteTable createTable(int rowNum, int tableId, int row1, int row2) {
        WriteTable table = null;
        if (rowNum > 1) {
            table = EasyExcel.writerTable(tableId).needHead(false).registerWriteHandler(createMergeStrategy(row1, row2, 0, 0)).build();
        } else {
            table = EasyExcel.writerTable(tableId).needHead(false).build();
        }
        return table;
    }

    private WriteHandler createMergeStrategy(int row1, int row2, int col1, int col2) {
        return new MergeStrategy(row1, row2, col1, col2);
    }

    private WriteHandler createColumnLengthStrategy(Map<String, List<String>> map) {
        Map<Integer, Integer> columnMap = new HashMap<>();
        columnMap.put(0, map.keySet().stream().map(String::length).max(Integer::compareTo).orElse(10));
        int columnSize = map.values().stream().findFirst().map(List::size).orElse(0)/fieldNum;
        for (int i = 0; i < columnSize; i++) {
            columnMap.put(i+1, calColumnLength(map,i));
        }
        return new ColumnStrategy(columnMap);
    }

    private Integer calColumnLength(Map<String, List<String>> map, int index){
//        return map.values().stream().flatMap(Collection::stream).map(String::length).max(Integer::compareTo).orElse(20);
        return map.values().stream().map(x -> x.get(index)).map(String::length).max(Integer::compareTo).orElse(20) + 1;
    }

    private List<List<String>> createHead() {
        List<List<String>> head = new ArrayList<>();
        head.add(Collections.singletonList("类名"));
        head.add(Collections.singletonList("类描述"));
        head.add(Collections.singletonList("地址"));
        head.add(Collections.singletonList("描述"));
        head.add(Collections.singletonList("参数"));
        return head;
    }

}
 