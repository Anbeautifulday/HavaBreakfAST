package so.go2.sharingthegym;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.commons.MenuSheetView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import so.go2.sharingthegym.model.uploadModel;
import so.go2.sharingthegym.net.ApiService;
import so.go2.sharingthegym.net.MyHttpURL;
import so.go2.sharingthegym.net.RetrofitClient;

public class PayActivity extends AppCompatActivity {

    private static final String TAG = "MY_TAG";
    @BindView(R.id.sheet_bottom)
    BottomSheetLayout bottomSheet;

    @OnClick(R.id.commit) void commit(){
        bottomSheet.showWithSheetView(menuSheetView);
    }

    private MenuSheetView menuSheetView;
    private TextView orderShowName;
    private TextView orderShowMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        orderShowName = (TextView) findViewById(R.id.orderShowName);
        orderShowMoney = (TextView) findViewById(R.id.orderShowMoney);

        Intent intent = getIntent();
        String name  = intent.getStringExtra("name");
        String money = intent.getStringExtra("money");

        orderShowName.setText(name);
        orderShowMoney.setText(money);

        ButterKnife.bind(this);
        initMenuSheet();
        //测试
        test ();
    }

    private void test() {
        RetrofitClient.create(ApiService.class)
                .upload(10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<uploadModel>() {
                    @Override
                    public void accept(uploadModel uploadModel) throws Exception {
                        Log.d(TAG, "accept: " + uploadModel
                                .getArticles().get(0).getArticleId());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "accept: " + throwable.getMessage());
                    }
                });
    }

    private void initMenuSheet() {
        menuSheetView =
                new MenuSheetView(this, MenuSheetView.MenuType.GRID, R.string.choosePay , new MenuSheetView.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();

                        switch (id) {
                            case R.id.pay_ali :
                                MyHttpURL.get("http://139.199.63.27/start.php?sn=01&time=80", new MyHttpURL.Callback() {
                                    @Override
                                    public void onResponse(String response) {
                                        finish();
                                        Toast.makeText(PayActivity.this, getResources().getString(R.string.success), Toast.LENGTH_SHORT).show();
                                    }
                                });
                                break;
                            case R.id.pay_we_chat :
                                MyHttpURL.get("http://139.199.63.27/start.php?sn=01&time=40", new MyHttpURL.Callback() {
                                    @Override
                                    public void onResponse(String response) {
                                        finish();
                                        Toast.makeText(PayActivity.this, getResources().getString(R.string.success), Toast.LENGTH_SHORT).show();
                                    }
                                });
                                break;
                        }

                        if (bottomSheet.isSheetShowing()) {
                            bottomSheet.dismissSheet();
                        }
                        return true;
                    }
                });
        menuSheetView.inflateMenu(R.menu.method_pay);
    }
}
