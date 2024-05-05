package business;

/**
 * {@code @Param} <T> O tipo de dado a ser criado
 * {@code @Param} <S> O tipo de dado recebido
 **/

public interface DataHandler<T, S> {

    T treatData(S data);
}
