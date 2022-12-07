package data_access;

import java.util.List;

public interface Observable<K> {
    void addObserver(K observer);

    void removeObserver(K observer);

    List<K> getObservers();

    void setObservers(List<K> observers);

    void notifyObserver(K observer);
}
