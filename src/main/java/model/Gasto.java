package model;

import javafx.beans.property.*;

public class Gasto {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty descripcion = new SimpleStringProperty();
    private final DoubleProperty monto = new SimpleDoubleProperty();
    private final StringProperty fecha = new SimpleStringProperty();

    public Gasto(int id, String descripcion, double monto, String fecha) {
        this.id.set(id);
        this.descripcion.set(descripcion);
        this.monto.set(monto);
        this.fecha.set(fecha);
    }

    public Gasto(String descripcion, double monto, String fecha) {
        this.descripcion.set(descripcion);
        this.monto.set(monto);
        this.fecha.set(fecha);
    }

    public int getId() { return id.get(); }
    public IntegerProperty idProperty() { return id; }

    public String getDescripcion() { return descripcion.get(); }
    public StringProperty descripcionProperty() { return descripcion; }

    public double getMonto() { return monto.get(); }
    public DoubleProperty montoProperty() { return monto; }

    public String getFecha() { return fecha.get(); }
    public StringProperty fechaProperty() { return fecha; }
}
