package com.study.dispatch;

import com.study.dto.RPCTransformObj;

import java.lang.reflect.Method;

public class ServiceDispatch {


    /**
     * 服务分发层，主要是隔离网络调用
     * @param obj
     * @return
     */
    public  static   Object  dispatch(Object  obj){
        //TODO 使用反射获取调用的接口

        RPCTransformObj  reqObj = (RPCTransformObj)obj;
        String classPath = reqObj.getClassPath();
        String methodName = reqObj.getMethodName();
        Object[] params = reqObj.getParams();

        //TODO 参数类型列表
        Class[]  types =  new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            types[i] = params[i].getClass();
        }

        Object invoke = null ;
        try{
            //TODO 通过反射获取类
            Class<?> clazz = Class.forName(classPath);
            //TODO 通过反射获取方法
            Method method = clazz.getDeclaredMethod(methodName, types);
            //TODO 调用方法
            invoke = method.invoke(clazz.newInstance(),params);
        }catch (Exception  e){
            e.printStackTrace();
        }

        return invoke ;
    }

}
