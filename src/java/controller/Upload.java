/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.ManageUser;
import ejb.UserResource;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Post;

/**
 *
 * @author DELL
 */
@WebServlet(name = "Upload")
@MultipartConfig(location ="/tmp")

public class Upload extends HttpServlet {
    @EJB
    private ManageUser mu;
    
    
    public Upload() {}
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        long yourmilliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");    
        Date resultdate = new Date(yourmilliseconds);
        String date = sdf.format(resultdate);
        int userId = Integer.parseInt(session.getAttribute("userid").toString());
        String path ="/var/www/html/myapp/" + session.getId() + "/" + getFilename(request.getPart("upload"));
        //String path = getFilename(request.getPart("upload"));
        Post post = new Post(description,title, path , resultdate,"Helsinki","png", userId );
        
        request.getPart("upload").write(getFilename(request.getPart("upload")));
        File userDir = new File("/home/glassfish/glassfish4/glassfish/domains/domain1/applications/PixShare/uploaded/" + Integer.parseInt(session.getAttribute("userid").toString()));
        if(!userDir.exists()){
            userDir.mkdir();
        }
        if (!userDir.exists() && !userDir.mkdirs()) {
        throw new IOException("Unable to create " + userDir.getAbsolutePath());
    }
       
        File file = new File("/tmp/"  + getFilename(request.getPart("upload")));
       
        File destinationDir = new File("/home/glassfish/glassfish4/glassfish/domains/domain1/applications/PixShare/uploaded/" + Integer.parseInt(session.getAttribute("userid").toString()));
        while(!file.renameTo(new File(destinationDir + "/" + file.getName()))) {
            int i =1;
            i++;
            file = new File(file+"(" + i + ")");
            file.renameTo(new File(destinationDir + "/" + file.getName()));
        }

        //mu.addPost(post);    
        
        
        
        //insert to database
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private static String getFilename(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
            return content.substring(content.indexOf('=') +
            1).trim().replace("\"", "");
            }
        }
    return null;
    }
}
