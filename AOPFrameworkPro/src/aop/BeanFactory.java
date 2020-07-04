package aop;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class BeanFactory {
    //为了获取ProxyFactoryBean对象
    Properties prop = new Properties();
    public BeanFactory(InputStream in){
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Object getBean(String name){
        Object bean = null;
        String className = prop.getProperty(name);
        try {
            //通过类名全称反射实例化对象
            Class aClass = Class.forName(className);
            bean = aClass.newInstance();
            //根据配置文件，实例化target和advice对象
            Object target = Class.forName(prop.getProperty(name + ".target")).newInstance();
            Object advice = Class.forName(prop.getProperty(name + ".advice")).newInstance();
            //把target和advice对象装配到bean对象的属性上
            //内省（jdk api）
            //通过一个字节码对象获取类结构信息对象
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor pd:propertyDescriptors){
                String pdName = pd.getName();  //获取属性的名称
                Method writeMethod = pd.getWriteMethod();
                if("target".equals(pdName)){
                    writeMethod.invoke(bean,target); //等同与bean.setTarget(target)
                }else if("advice".equals(pdName)){
                    writeMethod.invoke(bean,advice);
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
