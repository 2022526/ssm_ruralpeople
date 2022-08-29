package com.zyt.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 村民实体类
 */

@NameStyle(Style.normal)
@NoArgsConstructor
@Data
@Table(name = "tb_villager")
public class Villager {

    @Id
    private String id;
    private String name;
    private String age;
    private String id_number;
    private String relationship;
    private String  rural_id;
    private String  origin;

}
