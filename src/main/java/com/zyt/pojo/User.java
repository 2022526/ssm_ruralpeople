package com.zyt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

@NameStyle(Style.normal)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_user")
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private String head_sculpture; // 用户头像
}
