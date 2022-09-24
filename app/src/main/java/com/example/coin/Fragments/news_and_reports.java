package com.example.coin.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coin.Adapters.NewsAdapter;
import com.example.coin.Models.NewsData;
import com.example.coin.NewsDetails;
import com.example.coin.R;

import java.util.ArrayList;


public class news_and_reports extends Fragment {

    public news_and_reports() {
        // Required empty public constructor
    }


    ArrayList<NewsData> newsData;
    RecyclerView recyclerView;
    NewsAdapter adapter ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_and_reports, container, false);

        recyclerView = view.findViewById(R.id.rec_news_and_reports);

        newsData = getCustomList();
        adapter = new NewsAdapter(newsData);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        adapter.onItemClickListener(new NewsAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), NewsDetails.class);
                intent.putExtra("img",newsData.get(position).getIv_news_item());
                intent.putExtra("title",newsData.get(position).getTitle_news_item());
                intent.putExtra("time",newsData.get(position).getTime_news_item());
                intent.putExtra("text",newsData.get(position).getBig_text());
                startActivity(intent);
            }
        });
        return view;
    }

    private ArrayList<NewsData> getCustomList() {
        newsData = new ArrayList<>();
        String text = "باستثناء عملة الريبل والتي أظهرت أداءاً ضعيفاً طوال الأسابيع القليلة الماضية، فإن العملات الرقمية الرئيسية في السوق بما في ذلك البيتكوين والاثيريوم وكاردانو قد ارتفعت قيمتها. وفي غضون الـ 24 ساعة الماضية، ازداد سعر البيتكوين بنسبة 8% وارتفعت قيمة الإيثر بنسبة 10%، كما وارتفعت قيمة كاردانو بنسبة 15%. وبينما انخفض سعر العملات الثلاث بهامش ضئيل في الثلاث ساعات الماضية، إلا أنهم لا زالوا يسجلون مكاسب يومية كبيرة نسبياً.\n" +
                "\n" +
                "شعبية البيتكوين\n" +
                "خلال عملية التصحيحٍ الكبيرة التي حدثت في أوائل كانون الثاني/يناير، هبطت أسعار معظم العملات الرقمية بنسبة أكثر من 50% من أعلى قيمة لها، إلا أنه من ناحية أخرى ازدادت شعبية البيتكوين أكثر. حيث أقبل المستثمرون على العملات الرقمية ذات التقلبات الأقل في الأسعار. وفي ذلك الوقت، ارتفع مؤشر هيمنة البيتكوين إلى 38%، إذ تعافت العملة من أدنى مستوياتها بعد انخفاض بنسبة  32%. وخلال الأسبوع الماضي، انخفض مؤشر هيمنة البيتكوين من 38% إلى 34%، مع انخفاض حجم معاملات البيتكوين اليومية إلى أكثر من النصف، أي من 490.000 إلى 242.000 دولار.";
        newsData.add(new NewsData(R.drawable.bitmap,"انتعاش في قيمة العملات الرقمية الرئيسية تمثلت بارتفاع كل من البيتكوين والاثيريوم وكاردانو","12/22/2018",text));
        newsData.add(new NewsData(R.drawable.img_news,"الآن هو الوقت الأفضل للاستثمار في البيتكوين، بالرغم من عمليات التصحيح الأخيرة","12/22/2018",text));
        newsData.add(new NewsData(R.drawable.imgs_news,"منصة Coinbase تجني 2.7 مليون دولار يوميًا","12/22/2018",text));
        newsData.add(new NewsData(R.drawable.bitmap,"معالج المدفوعات “Stripe” يتوقف عن قبول مدفوعات عملة البيتكوين","12/22/2018",text));
        newsData.add(new NewsData(R.drawable.img_news,"كيف ستكون العملة الرقمية الخاصة بالفيسبوك؟","12/22/2018",text));
        newsData.add(new NewsData(R.drawable.imgs_news,"منصة Coinbase تجني 2.7 مليون دولار يوميًا","12/22/2018",text));
        newsData.add(new NewsData(R.drawable.bitmap,"منصة Coinbase تجني 2.7 مليون دولار يوميًا","12/22/2018",text));
        newsData.add(new NewsData(R.drawable.img_news,"منصة Coinbase تجني 2.7 مليون دولار يوميًا","12/22/2018",text));
        newsData.add(new NewsData(R.drawable.imgs_news,"منصة Coinbase تجني 2.7 مليون دولار يوميًا","12/22/2018",text));
        newsData.add(new NewsData(R.drawable.bitmap,"منصة Coinbase تجني 2.7 مليون دولار يوميًا","12/22/2018",text));
        newsData.add(new NewsData(R.drawable.bitmap,"منصة Coinbase تجني 2.7 مليون دولار يوميًا","12/22/2018",text));
        return newsData;
    }

}