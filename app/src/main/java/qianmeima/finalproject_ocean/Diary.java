package qianmeima.finalproject_ocean;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Diary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.diary, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.save_writing_page:
//                Intent intent = new Intent(Diary.this, ReadingPage.class);
//                startActivity(intent);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//
//    }
}
