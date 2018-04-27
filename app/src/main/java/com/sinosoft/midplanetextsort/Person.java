package com.sinosoft.midplanetextsort;

import android.support.annotation.NonNull;

/**
 * Created by Mars on 2018/4/27.
 */

public class Person implements Comparable<Person>{
    private String name;
    private String pinyin;
    private String firstLetter;

    public Person(String name, String pinyin) {
        this.name = name;
        this.pinyin = pinyin;
        firstLetter = pinyin.substring(0, 1).toUpperCase(); // 获取拼音首字母并转成大写
        if (!firstLetter.matches("[A-Z]")) { // 如果不在A-Z中则默认为“#”
            firstLetter = "#";
        }
    }

    public String getName() {
        return name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    @Override
    public int compareTo(@NonNull Person person) {
        if (firstLetter.equals("#") && !person.getFirstLetter().equals("#")) {
            return 1;
        } else if (!firstLetter.equals("#") && person.getFirstLetter().equals("#")){
            return -1;
        } else {
            return pinyin.compareToIgnoreCase(person.getPinyin());
        }
    }
}
