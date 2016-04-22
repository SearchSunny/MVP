package sample.mv.mvpsample.mvpsample.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import sample.mv.mvpsample.R;
import sample.mv.mvpsample.mvpsample.model.MainModelBean;
import sample.mv.mvpsample.mvpsample.presenter.MainPresenter;
import sample.mv.mvpsample.mvpsample.view.IMainView;

/**
 * MVP模式示例
 * 实现VIEW里的方法，包含一个Presenter的引用
 */
public class MainActivity extends AppCompatActivity implements IMainView {

    private ProgressBar mProgressBar;
    private TextView textView;
    private MainPresenter mainPresenterImplement;
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){

        textView = (TextView) findViewById(R.id.mText);
        mProgressBar = (ProgressBar) findViewById(R.id.mProcessBar);

        mainPresenterImplement = new MainPresenter(this);

        //延迟效果
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                mainPresenterImplement.loadData();
            }
        },2000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
        mainPresenterImplement.detachView();

    }

    @Override
    public void showData(MainModelBean mainModelBean) {

        String showData = getResources().getString(R.string.city) + mainModelBean.getCity()+"\n"
                + getResources().getString(R.string.wd) + mainModelBean.getWd()+"\n"
                + getResources().getString(R.string.ws) + mainModelBean.getWs()+"\n"
                + getResources().getString(R.string.time) + mainModelBean.getTime();

        textView.setText(showData);
    }

    @Override
    public void showProgress() {

        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {

        mProgressBar.setVisibility(View.GONE);
    }
}
