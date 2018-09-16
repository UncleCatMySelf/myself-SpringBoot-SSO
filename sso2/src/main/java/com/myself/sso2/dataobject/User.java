package com.myself.sso2.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 11:46 2018\9\16 0016
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@Entity
public class User implements Serializable{

    private static final long serialVersionUID = -7594700426109440104L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private Date createTime;

    private Date updateTime;
}
