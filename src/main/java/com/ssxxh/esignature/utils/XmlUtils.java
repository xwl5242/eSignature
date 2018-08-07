package com.ssxxh.esignature.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * xml格式化工具类
 * @author Administrator
 *
 */
@SuppressWarnings("deprecation")
public class XmlUtils {

	/**
     * XML转对象
     * @param clazz 对象类
     * @param str xml字符串
     * @param <T> T
     * @return
     */
    public static <T> T parseFromXml(Class<T> clazz, String xml) {
        //创建解析XML对象
        XStream xStream = new XStream(new DomDriver());
        //处理注解
        xStream.processAnnotations(clazz);
        @SuppressWarnings("unchecked")
        //将XML字符串转为bean对象
        T t = (T)xStream.fromXML(xml);
        return t;
    }
    
	/**
     * 对象转xml
     * @param obj 对象
     * @return xml字符串
     */
    public static String toXml(Object obj) {
        XStream xStream = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
        xStream.processAnnotations(obj.getClass());
        return ESConst.XML_TITLE + xStream.toXML(obj);
    }
    
}
