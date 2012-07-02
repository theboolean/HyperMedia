package it.polimi.phict.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class EuropeController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("europe.jsp");
    }
}