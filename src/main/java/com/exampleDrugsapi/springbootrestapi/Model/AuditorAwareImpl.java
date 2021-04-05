package com.exampleDrugsapi.springbootrestapi.Model;

import org.springframework.data.domain.AuditorAware;

import javax.swing.text.html.Option;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor(){return Optional.of("Esh");}
}
