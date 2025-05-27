/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ListarClientes", urlPatterns = {"/ListarClientes"})
public class ListarClientes extends HttpServlet {

    private final String url = "jdbc:mysql://localhost:3306/cliente";
    private final String user = "root";
    private final String password = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Listar clientes
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);
                String sql = "SELECT codiClie, ndniClie, appaClie, apmaClie, nombClie, fechNaciClie FROM clientes";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int codiClie = rs.getInt("codiClie");
                    String ndniClie = rs.getString("ndniClie");
                    String appaClie = rs.getString("appaClie");
                    String apmaClie = rs.getString("apmaClie");
                    String nombClie = rs.getString("nombClie").replace("'", "\\'");
                    String fechNaciClie = rs.getString("fechNaciClie");

                    out.println("<tr>");
                    out.println("<td>" + codiClie + "</td>");
                    out.println("<td>" + ndniClie + "</td>");
                    out.println("<td>" + appaClie + "</td>");
                    out.println("<td>" + apmaClie + "</td>");
                    out.println("<td>" + nombClie + "</td>");
                    out.println("<td>" + fechNaciClie + "</td>");
                    out.println("<td>");
                    out.println("<button class='btn btn-warning btn-sm' onclick=\"editarCliente("
                            + codiClie + ",'"
                            + ndniClie + "','"
                            + appaClie + "','"
                            + apmaClie + "','"
                            + nombClie + "','"
                            + fechNaciClie + "')\">Editar</button> ");
                    out.println("<button class='btn btn-danger btn-sm' onclick='eliminarCliente(" + codiClie
                            + ")'>Eliminar</button>");
                    out.println("</td>");
                    out.println("</tr>");
                }
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
                out.println("<tr><td colspan='7'>Error al conectar o consultar la base de datos.</td></tr>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if ("agregar".equals(accion)) {
            agregarCliente(request, response);
        } else if ("eliminar".equals(accion)) {
            eliminarCliente(request, response);
        } else if ("editar".equals(accion)) {
            editarCliente(request, response);
        }
    }

    private void agregarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ndniClie = request.getParameter("ndniClie");
        String appaClie = request.getParameter("appaClie");
        String apmaClie = request.getParameter("apmaClie");
        String nombClie = request.getParameter("nombClie");
        String fechNaciClie = request.getParameter("fechNaciClie");
        String logiClie = request.getParameter("logiClie");
        String passClie = request.getParameter("passClie");

        String sql = "INSERT INTO clientes (ndniClie, appaClie, apmaClie, nombClie, fechNaciClie, logiClie, passClie) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ndniClie);
            ps.setString(2, appaClie);
            ps.setString(3, apmaClie);
            ps.setString(4, nombClie);
            ps.setString(5, fechNaciClie);
            ps.setString(6, logiClie);
            ps.setString(7, passClie);
            ps.executeUpdate();
            ps.close();
            con.close();
            response.setContentType("text/plain");
            response.getWriter().write("success");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("error");
        }
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codiClie = request.getParameter("codiClie");
        String sql = "DELETE FROM clientes WHERE codiClie = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(codiClie));
            ps.executeUpdate();
            ps.close();
            con.close();
            response.setContentType("text/plain");
            response.getWriter().write("success");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("error");
        }
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codiClie = request.getParameter("codiClie");
        String ndniClie = request.getParameter("ndniClie");
        String appaClie = request.getParameter("appaClie");
        String apmaClie = request.getParameter("apmaClie");
        String nombClie = request.getParameter("nombClie");
        String fechNaciClie = request.getParameter("fechNaciClie");

        String sql = "UPDATE clientes SET ndniClie=?, appaClie=?, apmaClie=?, nombClie=?, fechNaciClie=? WHERE codiClie=?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ndniClie);
            ps.setString(2, appaClie);
            ps.setString(3, apmaClie);
            ps.setString(4, nombClie);
            ps.setString(5, fechNaciClie);
            ps.setInt(6, Integer.parseInt(codiClie));
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
