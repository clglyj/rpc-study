package com.study.dto;

import lombok.Data;

import java.io.Serializable;


//需要对象在不同进程中传输
@Data
public class UserDTO  implements Serializable {

    private static final long serialVersionUID = -5613047882860558539L;


    private  String name ;
    private   int age;
    private String  userId ;



}
