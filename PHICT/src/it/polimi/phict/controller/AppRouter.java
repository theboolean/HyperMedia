package it.polimi.phict.controller;

import org.slim3.controller.router.RouterImpl;

public class AppRouter extends RouterImpl {

    public AppRouter() {
        addRouting(
            "/{app}/projects/show/{key}",
            "/{app}/projects/show?key={key}");
    }
}