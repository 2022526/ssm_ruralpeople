package com.zyt.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 乡村实体类
 */

@NameStyle(Style.normal)
@NoArgsConstructor
@Data
@Table(name = "tb_rural")
public class Rural {

    @Id
    private String id;
    private String rural_name;
}
