package com.osckorea.webadmin.global.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
@Slf4j
public class RedisOperator<T> {
    @Autowired
    @Qualifier("redisObjectTemplate")
    private RedisTemplate<String, T> redisTemplate;

    @Resource(name = "redisObjectTemplate")
	private ValueOperations<String, T> valueOps;
	
	@Resource(name = "redisObjectTemplate")
	private ValueOperations<String, List<T>> valueOpsList;

	public RedisOperator(){		
	}
    public T getValue(String key) {
		try {
			log.debug("RedisOperator getValue --- key: {}", key);
			return  valueOps.get(key);
			
		} catch (Exception e) {
			log.error("RedisOperator getValue error : {} " , e.getMessage());
			return null;
		}
	}
    public List<T> getListValue(String key) {
		try {
			log.debug("RedisOperator getListValue --- key: {}", key);
			return valueOpsList.get(key);
		} catch (Exception e) {
			log.error("RedisOperator getListValue error : {}", e.getMessage());
			return null;
		}
	}


    public void set(String key, T value, long timeout, TimeUnit timeUnit) {
        try {
            valueOps.set(key, value, timeout,  timeUnit);
			
			log.debug("RedisOperator set --- key:{}", key);
		} catch (Exception e) {
			log.error("RedisOperator set  error : {}", e.getMessage());
		}
    }

    public void setList(String key, List<T> list, long timeout, TimeUnit timeUnit){
		try {
			valueOpsList.set(key, list, timeout, timeUnit);
            log.debug("RedisOperator setList --- key: {}", key);
		} catch (Exception e) {
			log.error("RedisOperator setList  error: {}", e.getMessage());
		}
	}

    public void delete(String key) {
		try {
			redisTemplate.delete(key);
            log.debug("RedisOperator delete --- key: {}", key);
		} catch (Exception e) {
			log.error("RedisOperator delete  error: {}",  e.getMessage());
		}
	}

	public Iterable<byte[]> getRedisTemplate(RedisCallback<Iterable<byte[]>> redisCallback) {
		return (Iterable<byte[]>) redisTemplate.execute((RedisCallback<T>) redisCallback);
	}
    
}
