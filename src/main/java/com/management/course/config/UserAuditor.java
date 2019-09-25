package com.management.course.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/13 19:08
 */
@Configuration
public class UserAuditor implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable("manzuo");
    }
}
