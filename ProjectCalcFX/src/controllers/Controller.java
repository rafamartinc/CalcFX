package controllers;

import javafx.event.ActionEvent;
import models.Model;

abstract public class Controller {
    protected Model model;
    protected long number1;
    protected String operator;
    protected boolean start;
    
    public Controller() {
        model = new Model();
        number1 = 0;
        operator = "";
        start = true;
    }
    
    abstract public void process(ActionEvent event);
}