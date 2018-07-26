package com.example.base.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"ID", "名前", "概要", "更新日時"})
public class Demo {
    @JsonProperty("ID")
    private Long id;
    @JsonProperty("名前")
    private String name;
    @JsonProperty("概要")
    private String desc;
    @JsonProperty("更新日時")
    private Date modified;

    public Demo() {}

    public Demo(Long id, String name, String desc, Date modified) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.modified = modified;
    }

    // Getter/Setter
}