package com.study.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RPCTransformObj  implements Serializable {
    private static final long serialVersionUID = 7049213111747883391L;
    private String  classPath;
    private String methodName;
    private Object[] params;

}
