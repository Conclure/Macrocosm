package me.conclure.macrocosm.util.function;

public interface ThrowingSupplier<T,E extends Exception> {
    T get() throws E;
}
