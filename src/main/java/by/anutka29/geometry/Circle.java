package by.anutka29.geometry;

public class Circle extends Figure {

    protected Double r;

    public Circle(FigureDto dto) {
        super(dto);
        this.r = dto.r;
    };

    @Override
    protected Double square() {
        return Math.PI * Math.pow(r, 2);
    }

}
