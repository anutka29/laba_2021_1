package by.anutka29.geometry;

public class FigureFactory {
    public Figure createFigure(FigureDto data) {
        Figure figure = null;

        switch (data.type) {
            case CIRCLE:
                figure = new Circle(data);
                break;
            case CONE:
                figure = new Cone(data);
                break;
            case PARALLELEPIPED:
                figure = new Parallelepiped(data);
                break;

        }

        return figure;
    }
}
