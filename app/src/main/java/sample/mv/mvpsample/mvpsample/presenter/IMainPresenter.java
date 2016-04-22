package sample.mv.mvpsample.mvpsample.presenter;
import sample.mv.mvpsample.mvpsample.model.MainModelBean;

/**
 * Created by MV on 2016/4/21.
 * 此接口作用是连接Model
 */
public interface IMainPresenter {

    /**
     * 加载成功
     * @param mainModelBean
     */
    void loadDataSuccess(MainModelBean mainModelBean);

    /**
     * 加载失败
     */
    void loadDataFailure();
}
