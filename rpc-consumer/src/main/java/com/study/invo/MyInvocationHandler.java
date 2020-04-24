package com.study.invo;

import com.study.BIOClient;
import com.study.api.ServiceMapped;
import com.study.dto.RPCTransformObj;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler  implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //TODO 在代理对象的最终调用中封装描述接口调用信息的类
        RPCTransformObj rpcTransformObj = new RPCTransformObj();
        rpcTransformObj.setMethodName(method.getName());
        rpcTransformObj.setParams(args);

        //TODO  通过反射从注解中获取值
        Class<?> clazz = method.getDeclaringClass();
        String classPath = clazz.getDeclaredAnnotation(ServiceMapped.class).value();

        //TODO  其实dubbo中使用的配置文件，在配置文件中指定接口和实现类的对应关系
        rpcTransformObj.setClassPath(classPath);

        //TODO  发起网络请求

        return BIOClient.callRemorte("localhost", 8888, rpcTransformObj);
    }
}
