package com.example.springboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * describe:
 *
 * @author 林旭南(linxnsz @ sinosoft.com.cn)
 * @date 2019-12-25 下午 02:43
 */
@Data
@Entity
public class User {

    @Id   // 表明id
    @GeneratedValue   //  自动生成
    private Long id;

    @NotNull(message = "名字不能为空，请传值")
    @NotEmpty(message = "名字不能为空，请传值")
    private String name;

    @Column(nullable = false)
    @Convert(converter = Gentor.Converter.class)
    private Gentor gentor;

    @Transient
    private String temp;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    @Length(min = 11,max = 11,message = "传入的电话号码长度不正确，请检查")
    private String mobile ;

}
