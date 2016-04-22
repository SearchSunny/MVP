package sample.mv.mvpsample.mvpsample.model;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import sample.mv.mvpsample.mvpsample.presenter.IMainPresenter;

/**
 * Created by MV on 2016/4/21.
 * 业务具体处理，包括负责存储、检索、操纵数据等
 * MVP之M 回调Presenter方法
 */
public class MainModel {

    private static final String TAG = "MainModel";
    IMainPresenter mIMainPressenter;

    public MainModel(IMainPresenter iMainPresenter){

        this.mIMainPressenter = iMainPresenter;

    }

    public void loadData(){

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get("http://www.weather.com.cn/adat/sk/101010100.html", new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                try {


                    MainModelBean mainModelBean = new MainModelBean();
                    JSONObject weatherInfo = response.getJSONObject("weatherinfo");
                    Log.d( TAG,weatherInfo.getString("city"));
                    mainModelBean.setCity(weatherInfo.getString("city"));
                    mainModelBean.setWd(weatherInfo.getString("WD"));
                    mainModelBean.setWs(weatherInfo.getString("WS"));
                    mainModelBean.setTime(weatherInfo.getString("time"));

                    mIMainPressenter.loadDataSuccess(mainModelBean);

                }catch (JSONException e){

                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode,Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.d( TAG,"statusCode="+statusCode);
                mIMainPressenter.loadDataFailure();
            }
        } );


    }
}
