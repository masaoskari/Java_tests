package com.example;

import java.util.List;

public class Program {
   
    private String id;
    private String code;
    private String lang;
    private String groupId;
    private String name;
    private String nameMatch;
    private String searchTagsMatch;
    private List<String> curriculumPeriodIds;
    private Credits credits;
    
    @Override
    public String toString() {
        return "Program [id=" + id + ", code=" + code + ", lang=" + lang + ", groupId=" + groupId + ", name=" + name
                + ", nameMatch=" + nameMatch + ", searchTagsMatch=" + searchTagsMatch + ", curriculumPeriodIds="
                + curriculumPeriodIds + ", credits=" + credits + "]";
    }

    private static class Credits {
        Integer min;
        Integer max;
    }
}
