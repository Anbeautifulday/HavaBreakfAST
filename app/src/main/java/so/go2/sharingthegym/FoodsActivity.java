package so.go2.sharingthegym;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import so.go2.sharingthegym.adapter.Food;
import so.go2.sharingthegym.adapter.FoodRecyclerAdapter;

public class FoodsActivity extends AppCompatActivity {

    private List<Food> foods;
    private RecyclerView recyclerView;
    private FoodRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        foods = new ArrayList<>();
        ininFoods();

        recyclerView = (RecyclerView) findViewById(R.id.foodsRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new SpaceItemDecoration(28));
        adapter = new FoodRecyclerAdapter(this, foods);
        recyclerView.setAdapter(adapter);
    }

    private void ininFoods() {
        Food food1 = new Food(R.drawable.food1, "豆浆加奶酪，完美组合，满足你每天的蛋白质需求");
        foods.add(food1);
        Food food2 = new Food(R.drawable.food2, "豆浆加奶酪，完美组合，满足你每天的蛋白质需求");
        foods.add(food2);
        Food food3 = new Food(R.drawable.food3, "豆浆加奶酪，完美组合，满足你每天的蛋白质需求");
        foods.add(food3);
        Food food4 = new Food(R.drawable.food4, "豆浆加奶酪，完美组合，满足你每天的蛋白质需求");
        foods.add(food4);
        Food food5 = new Food(R.drawable.food5, "豆浆加奶酪，完美组合，满足你每天的蛋白质需求");
        foods.add(food5);
        Food food6 = new Food(R.drawable.food6, "豆浆加奶酪，完美组合，满足你每天的蛋白质需求");
        foods.add(food6);
        Food food7 = new Food(R.drawable.food7, "豆浆加奶酪，完美组合，满足你每天的蛋白质需求");
        foods.add(food7);
        Food food8 = new Food(R.drawable.food8, "豆浆加奶酪，完美组合，满足你每天的蛋白质需求");
        foods.add(food8);
    }

    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        int mSpace ;

        //传入的值，其单位视为dp
        public SpaceItemDecoration(int space) {
            this.mSpace = DensityUtils.dp2px(FoodsActivity.this, space);
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int itemCount = adapter.getItemCount();
            int pos = parent.getChildAdapterPosition(view);

            outRect.left = 0;
            outRect.top = 0;
            outRect.bottom = 0;


            if (pos != (itemCount -1)) {
                outRect.bottom = mSpace;
            } else {
                outRect.right = 0;
            }
        }
    }

    public static class DensityUtils {
        //dp->dx
        public static int dp2px(Context context, float dpVal) {
            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    dpVal, context.getResources().getDisplayMetrics());
        }
    }
}
