/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author MINH
 */
public class Execute extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter() ;
            /* TODO output your page here. You may use following sample code. */
            
              String num1=request.getParameter("num1");
            String num2=request.getParameter("num2");
            int num_1=Integer.parseInt(num1);
            int num_2=Integer.parseInt(num2);
            
            if(num1.isEmpty()||num2.isEmpty()){
            out.println(" You must input texts");
            }else if(num_1<=0||num_2<=0){
            out.println(" You must input an integer > 0");
            }
            else{
            int uoc;
            for(int i=1;i<=3;i++){
            uoc=tinhUocChungNhoNhat(num_1, num_2)*i;
            out.print(uoc+" " );
            }
            }
            
    } 
    public static int tinhUocChungNhoNhat(int a, int b) {
    // Đảm bảo a luôn là số nhỏ nhất
    if (a > b) {
        int temp = a;
        a = b;
        b = temp;
    }
    
    // Tìm ước chung nhỏ nhất
    for (int i = a; i <= a * b; i++) {
        if (i % a == 0 && i % b == 0) {
            return i;
        }
    }
    
    return a * b; // Trong trường hợp không tìm thấy, trả về a * b
}

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
