package it.polimi.phict.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class ResultsController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("results.jsp");
    }
}