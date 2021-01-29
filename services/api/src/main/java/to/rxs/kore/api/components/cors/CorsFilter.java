package to.rxs.kore.api.components.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;

public class CorsFilter {

    @Bean
    public CorsWebFilter corsWebFilter() {
        var cors = new CorsConfiguration();
        cors.applyPermitDefaultValues();

        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cors);
        return new CorsWebFilter((CorsConfigurationSource) source);
    }

}
