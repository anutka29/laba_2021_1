package by.anutka29.laba;

import by.anutka29.geometry.Figure;
import by.anutka29.geometry.FigureDto;
import by.anutka29.geometry.FigureFactory;
import by.anutka29.geometry.FigureType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "MainServlet", urlPatterns = "/figure")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sizeA = req.getParameter("size_a");
        String sizeB = req.getParameter("size_b");
        String sizeC = req.getParameter("size_c");

        String scale = req.getParameter("scale");
        String figureType = req.getParameter("figure");
        req.setAttribute("size_a", sizeA);
        req.setAttribute("size_b", sizeB);
        req.setAttribute("size_c", sizeC);
        req.setAttribute("scale", scale);
        req.setAttribute("figure", figureType);

        String figure_name = null;
        FigureFactory figureFactory = new FigureFactory();
        try {
            FigureDto dto = new FigureDto();
            switch (figureType) {
                case "circle" :
                    dto.type = FigureType.CIRCLE;
                    figure_name = "Circle";
                    break;
                case "cone" :
                    dto.type = FigureType.CONE;
                    figure_name = "Cone";
                    break;
                case "parallelepiped" :
                    dto.type = FigureType.PARALLELEPIPED;
                    figure_name = "Parallelepiped";
                    break;
            }

            Double dSizeB = sizeB.length() > 0 ? Double.valueOf(sizeB) : null;
            dto.a = Double.valueOf(sizeA);
            dto.b = dSizeB;
            dto.c = sizeC.length() > 0 ? Double.valueOf(sizeC) : null;
            dto.h = dSizeB;
            dto.r = Double.valueOf(sizeA);
            dto.scale = Integer.parseInt(scale);
            Figure figure = figureFactory.createFigure(dto);

            String square = String.valueOf(figure.result());
            req.setAttribute("square", square);
            req.setAttribute("figure_name", figure_name);
            Integer figure_scale = figure.getScale();
            if (figure_scale != null) {
                req.setAttribute("figure_scale", figure_scale.toString());
            }
            else {
                req.setAttribute("figure_scale", "scale not set");
            }

        } catch (Exception e) {
            req.setAttribute("square", "Error: " + e.getMessage());
        }

        this.getServletContext().getRequestDispatcher("/figure.jsp").forward(req, resp);
    }

}
