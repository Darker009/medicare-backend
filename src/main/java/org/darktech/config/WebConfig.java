/*
 * package org.darktech.config;
 * 
 * 
 * import org.springframework.beans.factory.annotation.Value; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.web.servlet.config.annotation.CorsRegistry; import
 * org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
 * import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 * 
 * @Configuration public class WebConfig implements WebMvcConfigurer {
 * 
 * @Value("${app.image.upload.user-path}") private String userUploadPath;
 * 
 * @Value("${app.image.upload.book-path}") private String bookUploadPath;
 * 
 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
 * String normalizedUserPath = userUploadPath.endsWith("/") ? userUploadPath :
 * userUploadPath + "/";
 * 
 * registry.addResourceHandler("/uploads/users/**")
 * .addResourceLocations("file:" + normalizedUserPath) .setCachePeriod(3600)
 * .resourceChain(true);
 * 
 * 
 * 
 * registry.addResourceHandler("/static/**")
 * .addResourceLocations("classpath:/static/") .setCachePeriod(3600); }
 * 
 * @Override public void addCorsMappings(CorsRegistry registry) {
 * registry.addMapping("/**") .allowedOrigins( "http://localhost:5173",
 * "http://127.0.0.1:5173", "https://book-vault-frontend-one.vercel.app",
 * "https://bookvault.nextechvision.in" ) .allowedMethods("GET", "POST", "PUT",
 * "DELETE", "PATCH", "OPTIONS") .allowedHeaders("*")
 * .exposedHeaders("Authorization", "Content-Type", "Content-Disposition",
 * "Cache-Control") .allowCredentials(true) .maxAge(3600); } }
 */