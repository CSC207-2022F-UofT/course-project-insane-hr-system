package ui;

import data_access.Observable;

import java.util.List;

public interface Observer<T, K> {
    List<T> getObservables();

    void setObservables(List<T> observables);

    void update(K information);

    void addObservable(T observable);

    void removeObservable(T observable);
}
