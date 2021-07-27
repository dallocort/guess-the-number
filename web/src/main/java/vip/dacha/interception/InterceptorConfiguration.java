package vip.dacha.interception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfiguration implements WebMvcConfigurer {

    ProbaInterception probaInterception;

    public InterceptorConfiguration(ProbaInterception probaInterception) {
        this.probaInterception = probaInterception;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(probaInterception);
        //        registry.addInterceptor(new ProbaInterception()).addPathPatterns("/*");
    }
}
