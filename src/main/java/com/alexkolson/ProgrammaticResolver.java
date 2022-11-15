package com.alexkolson;

import io.quarkus.hibernate.orm.PersistenceUnitExtension;
import io.quarkus.hibernate.orm.runtime.tenant.TenantResolver;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@PersistenceUnitExtension
@ApplicationScoped
public class ProgrammaticResolver implements TenantResolver {
    private final Random random;

    public ProgrammaticResolver() {
        this.random = new Random();
    }

    @Override
    public String getDefaultTenantId() {
        return "tenant-default";
    }

    @Override
    public String resolveTenantId() {
        return String.format("tenant-%d", random.nextInt());
    }
}
