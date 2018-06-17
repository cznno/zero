package person.cznno.zero.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Spring 线程池
 * 使用的时候直接注入ThreadPoolTaskExecutor
 * Created by cznno
 * Date: 18-6-7
 */
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(50);
//        executor.setQueueCapacity(200);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }

}
