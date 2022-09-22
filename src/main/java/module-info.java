module model {
    requires javafx.graphics;
    requires javafx.controls;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    exports model to javafx.graphics;
}
