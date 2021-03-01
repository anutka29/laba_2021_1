package by.anutka29.geometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Figure {

    protected Integer scale;

    public Figure(FigureDto dto) {
        this.scale = dto.scale;
    };

    public Integer getScale() {
        return this.scale;
    }

    public Double result() {
        return BigDecimal.valueOf(this.square())
                .setScale(this.scale, RoundingMode.HALF_UP)
                .doubleValue();
    }

    protected abstract Double square();
}
