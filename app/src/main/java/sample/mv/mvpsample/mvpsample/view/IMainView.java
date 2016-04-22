package sample.mv.mvpsample.mvpsample.view;

import sample.mv.mvpsample.mvpsample.model.MainModelBean;

/**
 * Created by MV on 2016/4/21.
 *处理业务需要哪些方法
 * MVP之V
 */
public interface IMainView {

    void showData(MainModelBean mainModelBean);
    void showProgress();
    void hideProgress();
}
