package by.anutka29.geometry;

public class Parallelepiped extends Figure {

    protected Double a;
    protected Double b;
    protected Double c;

    public Parallelepiped(FigureDto dto) {
        super(dto);
        this.a = dto.a;
        this.b = dto.b;
        this.c = dto.c;
    }

    @Override
    protected Double square() {
        return 2 * (a * b + b * c + a * c);
    }

}
