package th.ac.su.cp.vocabeng;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import th.ac.su.cp.vocabeng.model.WordItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAdapter adapter = new MyAdapter();
        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);

        //เข้าถึง RecycleView ใน layout
        RecyclerView rv = findViewById(R.id.word_list_recycle_view);
        rv.setLayoutManager(lm); // กำหนด layout manager ให้กับ RecycleView
        rv.setAdapter(adapter); // กำหนด adapter ให้กับ RecycleView

    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        WordItem[] items ={
                new WordItem(R.drawable.washing,"WASHING MACHINE","เครื่องซักผ้า"),
                new WordItem(R.drawable.kettle,"ELECTRIC KETTLE","กาต้มน้ำ"),
                new WordItem(R.drawable.tv,"TELEVISION","โทรทัศน์"),
                new WordItem(R.drawable.microwave,"MICROWAVE","ไมโครเวฟ"),
                new WordItem(R.drawable.computer,"COMPUTER","คอมพิวเตอร์"),
                new WordItem(R.drawable.hair,"HAIR DRYER","เครื่องเป่าผม"),
                new WordItem(R.drawable.fan,"ELECTRIC FAN","พัดผม"),
                new WordItem(R.drawable.cleaner,"VACUUM CLEANER","เครื่องดูดฝุ่น"),
                new WordItem(R.drawable.refri,"REFRIGERATOR","ตู้เย็น"),
                new WordItem(R.drawable.pillow,"PILLOW","หมอน")



        };
        // WordItem item2;

        public MyAdapter(){
            /*item = new WordItem(R.drawable.cat,"CAT");
            item2 = new WordItem(R.drawable.dog,"DOG");*/

        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_word, parent, false);
            MyViewHolder vh = new MyViewHolder(v);
            return vh;

        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.imageView.setImageResource(items[position].imageResId);
            holder.wordTextView.setText(items[position].word);
            holder.wordTextView2.setText(items[position].word2);


        }


        public int getItemCount(){
            // return 10;
            return items.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView wordTextView;
            TextView wordTextView2;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.image_view);
                wordTextView = itemView.findViewById(R.id.word_text_view);
                wordTextView2 = itemView.findViewById(R.id.word_text_view2);
            }
        }
    }


    }
