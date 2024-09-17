package br.com.ndc.wildfly_demo;

import io.opentracing.util.GlobalTracer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class SpanInterceptor implements HandlerInterceptor {

    @Value("${app.version}")
    private String version;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final var span = GlobalTracer.get().activeSpan();
        if (span != null) {
            span.setTag("version", version);
        }

        // For debugging
        response.addHeader("x-version", version);
        return true;
    }
}
