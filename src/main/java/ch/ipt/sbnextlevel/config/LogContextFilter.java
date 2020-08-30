package ch.ipt.sbnextlevel.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class LogContextFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogContextFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Example: String requestId = UUID.randomUUID().toString();

        // TODO: Fill MDC with variable using MDC.put(key, value)

        try {
            chain.doFilter(request, response);
        } finally {
            LOGGER.debug("Clearing Mapped Diagnostic Context");
            MDC.clear();
        }
    }

}