package sample.mv.mvpsample.mvpsample.presenter;

/**
 * Created by MV on 2016/4/21.
 *
 */
public interface IPresenter<T> {

    void attachView(T view);

    void detachView();
}
