package com.dylan.xinyidai05;

import com.jayway.jsonpath.*;

import java.util.List;
import java.util.Map;

/**
 * @author baoxiang
 * @create 2020-07-07 10:24
 */
public class JsonPathTest {

    public static void main(String[] args) {

        String json = "{\n" +
                "    \"store\": {\n" +
                "        \"book\": [\n" +
                "            {\n" +
                "                \"category\": \"reference\",\n" +
                "                \"author\": \"Nigel Rees\",\n" +
                "                \"title\": \"Sayings of the Century\",\n" +
                "                \"price\": 8.95\n" +
                "            },\n" +
                "            {\n" +
                "                \"category\": \"fiction\",\n" +
                "                \"author\": \"Evelyn Waugh\",\n" +
                "                \"title\": \"Sword of Honour\",\n" +
                "                \"price\": 12.99\n" +
                "            },\n" +
                "            {\n" +
                "                \"category\": \"fiction\",\n" +
                "                \"author\": \"Herman Melville\",\n" +
                "                \"title\": \"Moby Dick\",\n" +
                "                \"isbn\": \" 0-553-21311-3\",\n" +
                "                \"price\": 8.99\n" +
                "            },\n" +
                "            {\n" +
                "                \"category\": \"fiction\",\n" +
                "                \"author\": \"J. R. R. Tolkien\",\n" +
                "                \"title\": \"The Lord of the Rings\",\n" +
                "                \"isbn\": \"0-395-19395-8\",\n" +
                "                \"price\": 22.99\n" +
                "            }\n" +
                "        ],\n" +
                "        \"bicycle\": {\n" +
                "            \"color\": \"red\",\n" +
                "            \"price\": 19.95\n" +
                "        }\n" +
                "    },\n" +
                "    \"expensive\": 10\n" +
                "}";
        DocumentContext parse = JsonPath.parse(json);
        Object read = null;
        read = parse.read("$.store.*");
        System.out.println(read);

        read = parse.read("$.store..price");
        System.out.println(read);

        read = parse.read("$..book[:2]");
        System.out.println(read);

        read = parse.read("$..book[1:2]");
        System.out.println(read);

        read = parse.read("$..book[?(@.isbn)]");
        System.out.println(read);

        read = parse.read("$.store.book[?(@.price < 10)]");
        System.out.println(read);

        List<String> list = parse.read("$.store.book[*].author",List.class);
        System.out.println(list);


        Predicate booksWithISBN = new Predicate() {
            @Override
            public boolean apply(PredicateContext ctx) {
                return ctx.item(Map.class).containsKey("isbn");
            }
        };

        List<String> books =
                parse.read("$.store.book[?].isbn", List.class, booksWithISBN);

//        books.forEach(x-> System.out.println(x));
        System.out.println(books);
        Configuration configuration = Configuration.defaultConfiguration();
        configuration.setOptions(Option.ALWAYS_RETURN_LIST);
        JsonPath.using(configuration).parse(json).read("$.store.book[?].isbn", List.class, booksWithISBN);
    }
}
 