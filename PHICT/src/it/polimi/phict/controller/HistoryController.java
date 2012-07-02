package it.polimi.phict.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class HistoryController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("static/history.jsp");
    }
}