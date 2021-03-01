package by.anutka29.geometry;

public class Cone extends Figure {

    protected Double r;
    protected Double h;

    public Cone(FigureDto dto) {
        super(dto);
        this.r = dto.r;
        this.h = dto.h;
    }

    @Override
    protected Double square() {
        return Math.PI * r * (r + Math.sqrt(Math.pow(r, 2) + Math.pow(h, 2)));
    }

}
