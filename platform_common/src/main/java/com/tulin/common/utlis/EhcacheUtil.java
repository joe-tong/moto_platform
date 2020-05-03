package com.tulin.common.utlis;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.net.URL;

/**
 * 缓存工具类
 * @author  tpp
 * @version 1.0 
 * @date 2017年8月9日
 *
 */
public class EhcacheUtil {

    private static CacheManager manager = null;
    
    static {
    	getInstance();
    }
    
    public static CacheManager getInstance(){
    	if (manager == null) {
    		URL url = EhcacheUtil.class.getResource("/ehcache/ehcache.xml");
    		manager = CacheManager.create(url);
		}
    	return manager;
    }
    

    /**
     * 向缓存放入要存储的内容
     * @return void
     * @date 2017年8月9日
     *
     */
    public static void put(String cacheName, String key, Object value) {
        Cache cache = manager.getCache(cacheName);
        Element element = new Element(key, value);
        cache.put(element);
    }
    /**
     * 向缓存取出要存储的内容
     * @return Object
     * @date 2017年8月9日
     *
     */
    public static Object get(String cacheName, String key) {
        Cache cache = manager.getCache(cacheName);
        Element element = cache.get(key);
        return element == null ? null : element.getObjectValue();
    }
    /**
     * 得到参数名称对应的缓存
     * @return Cache
     * @date 2017年8月9日
     *
     */
    public static Cache get(String cacheName) {
        return manager.getCache(cacheName);
    }
    /**
     * 移除参数名称对应的缓存
     * @return void
     * @date 2017年8月9日
     *
     */
    public static void remove(String cacheName, String key) {
        Cache cache = manager.getCache(cacheName);
        cache.remove(key);
    }
    
    public static void main(String[] args) {
    	Object object = EhcacheUtil.get("fiveMinsCache", "shixian");
    	EhcacheUtil.put("fiveMinsCache", "shixian", "石仙");
		System.out.println(object);
	}
}