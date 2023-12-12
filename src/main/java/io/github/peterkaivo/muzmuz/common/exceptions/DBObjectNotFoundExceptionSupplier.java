package io.github.peterkaivo.muzmuz.common.exceptions;

import java.util.function.Supplier;

public class DBObjectNotFoundExceptionSupplier implements Supplier<DBObjectNotFoundException> {
    private DBObjectNotFoundException dbObjectNotFoundException;

    public DBObjectNotFoundExceptionSupplier(Class<?> affectedClass, Long id) {
        this.dbObjectNotFoundException = new DBObjectNotFoundException(affectedClass, id);
    }
    @Override
    public DBObjectNotFoundException get() {
        return dbObjectNotFoundException;
    }
}
