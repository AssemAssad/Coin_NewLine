package com.example.coin.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coin.Adapters.AlarmCoinzAdapter;
import com.example.coin.Adapters.CustomSpinnerAdapter;
import com.example.coin.Models.CustomSpinnerItem;
import com.example.coin.Models.Rec_alarm_data;
import com.example.coin.R;

import java.util.ArrayList;


public class alarm_coinz_fragment extends Fragment {


    public alarm_coinz_fragment() {
    }

    Spinner sp_type_coinz, sp_val_alarm;
    EditText et_num;
    ArrayList<CustomSpinnerItem> arrayList;
    ArrayAdapter arrayAdapter;
    String text_equal, Num, itemName,num;
    Button btn_add_alarm;
    int itemImg ;

    Rec_alarm_data rec_alarm_data;

    ArrayList<Rec_alarm_data> recAlarmData;
    RecyclerView recyclerView;
    AlarmCoinzAdapter alarmCoinzAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_alarm_coinz_, container, false);

        sp_type_coinz = view.findViewById(R.id.sp_type_coinz);
        sp_val_alarm = view.findViewById(R.id.sp_val_alarm);
        et_num = view.findViewById(R.id.et_num);
        btn_add_alarm = view.findViewById(R.id.btn_add_alarm);
        recyclerView = view.findViewById(R.id.rec_alarm);

        arrayAdapter = ArrayAdapter.createFromResource(getContext(), R.array.spinner_num, R.layout.color_spinner_item);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdwon);
        sp_val_alarm.setAdapter(arrayAdapter);
        sp_val_alarm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                text_equal = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        arrayList = getCustomList();
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(getContext(), arrayList);
        sp_type_coinz.setAdapter(adapter);
        sp_type_coinz.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                CustomSpinnerItem spinnerItem = (CustomSpinnerItem) adapterView.getItemAtPosition(i);
                itemName = spinnerItem.getItemName();
                itemImg = spinnerItem.getItemImgs();
                //itemName = ((TextView) view.findViewById(R.id.tv_sp_item)).getText().toString();
                //itemImg = ((ImageView) view.findViewById(R.id.iv_sp_item));



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        recAlarmData = new ArrayList<>();
        alarmCoinzAdapter =new AlarmCoinzAdapter(recAlarmData);
        btn_add_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Num = et_num.getText().toString();
                if (Num.isEmpty()) {
                    Toast.makeText(getContext(), "Number Can't be empty", Toast.LENGTH_SHORT).show();
                } else {
                   // num = numCurrencyFormat(Num);
                    rec_alarm_data = new Rec_alarm_data(itemName,text_equal,Num,itemImg);
                    recAlarmData.add(rec_alarm_data);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(alarmCoinzAdapter);
                    alarmCoinzAdapter.setOnItemClickListener(new AlarmCoinzAdapter.onItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            recAlarmData.remove(position);
                            alarmCoinzAdapter.notifyItemRemoved(position);
                        }
                    });


                }
            }
        });





        return view;
    }

    private ArrayList<CustomSpinnerItem> getCustomList() {
        arrayList = new ArrayList<>();
        arrayList.add(new CustomSpinnerItem("Bitcoin بيتكوين", R.drawable.btcc));
        arrayList.add(new CustomSpinnerItem("Ripple ريبـل", R.drawable.xrp));
        arrayList.add(new CustomSpinnerItem("Litecoin لايت كوين", R.drawable.ltc));
        arrayList.add(new CustomSpinnerItem("Ethereum ايثيريوم", R.drawable.eth));
        return arrayList;
    }
    //private String numCurrencyFormat(String number){
       // DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
       // return decimalFormat.format(Double.parseDouble(number));
   // }
}