package***REMOVED***org.example.config;

import***REMOVED***org.springframework.context.annotation.Configuration;
import***REMOVED***org.springframework.web.servlet.config.annotation.CorsRegistry;
import***REMOVED***org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
***REMOVED*******REMOVED***CORS跨域配置
***REMOVED****/
@Configuration
public***REMOVED***class***REMOVED***CorsConfig***REMOVED***implements***REMOVED***WebMvcConfigurer***REMOVED***{

***REMOVED******REMOVED******REMOVED******REMOVED***@Override
***REMOVED******REMOVED******REMOVED******REMOVED***public***REMOVED***void***REMOVED***addCorsMappings(CorsRegistry***REMOVED***registry)***REMOVED***{
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***registry.addMapping("/**")
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***.allowedOriginPatterns("*")
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***.allowedMethods("GET",***REMOVED***"POST",***REMOVED***"PUT",***REMOVED***"DELETE",***REMOVED***"OPTIONS")
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***.allowedHeaders("*")
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***.allowCredentials(false)***REMOVED******REMOVED***//***REMOVED***改为false，避免与"*"冲突
***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***.maxAge(3600);
***REMOVED******REMOVED******REMOVED******REMOVED***}
}
