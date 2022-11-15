package com.alexkolson;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class GreetingService {

    @Transactional
    public void createNewGreeting() {
        new Greeting().persist();
    }
}
