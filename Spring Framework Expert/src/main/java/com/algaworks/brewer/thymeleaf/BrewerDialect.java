package com.algaworks.brewer.thymeleaf;

import com.algaworks.brewer.thymeleaf.processor.ClassForErrorAtrributeTagProcessor;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;

public class BrewerDialect extends AbstractProcessorDialect {

    public BrewerDialect() {
        super("AlgaWorks Brewer", "brewer", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        final Set<IProcessor> processadores = new HashSet<>();
        processadores.add(new ClassForErrorAtrributeTagProcessor(dialectPrefix));
        return processadores;
    }
}
