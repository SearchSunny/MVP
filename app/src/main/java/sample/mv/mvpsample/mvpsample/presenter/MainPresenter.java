package sample.mv.mvpsample.mvpsample.presenter;

import sample.mv.mvpsample.mvpsample.model.MainModel;
import sample.mv.mvpsample.mvpsample.model.MainModelBean;
import sample.mv.mvpsample.mvpsample.view.IMainView;

/**
 * Created by MV on 2016/4/21.
 * View和Model的桥梁，它从Model层检索数据后，返回给View层
 * MVP之P 回调View方法
 */
public class MainPresenter implements IPresenter<IMainView>,IMainPresenter {

    private IMainView mMainView;
    private MainModel mMainModel;

   public MainPresenter(IMainView mainView){

       attachView(mainView);
       mMainModel = new MainModel(this);
    }

    @Override
    public void attachView(IMainView view) {

        this.mMainView = view;
    }

    @Override
    public void detachView() {

        this.mMainView = null;
    }

    public void loadData(){
        mMainView.showProgress();
        mMainModel.loadData();

    }
    @Override
    public void loadDataSuccess(MainModelBean mainModelBean) {

        mMainView.showData(mainModelBean);
        mMainView.hideProgress();
    }

    @Override
    public void loadDataFailure() {

        mMainView.hideProgress();
    }


}
