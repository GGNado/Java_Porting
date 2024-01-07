package com.gigi.portingjavaospedale.controller;

import java.io.*;

import com.gigi.portingjavaospedale.model.PazienteDAO;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//@WebServlet(name = "Porting", value = "/Porting")
@WebServlet(urlPatterns = {"/api/patientJava"})
public class Porting extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(new Gson().toJson(PazienteDAO.getPazienti()));
    }
}