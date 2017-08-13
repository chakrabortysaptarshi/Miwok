package com.example.ssapt.miwok;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

       // openNumbers();
        //openFamily();
        //openColors();
        //openPhrases();
    }

   /* private void openNumbers() {
        TextView numbers = (TextView) findViewById(R.id.numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Toast(getApplicationContext()).makeText(getApplicationContext(), "List all numbers", Toast.LENGTH_SHORT).show();;
                Intent intent = new Intent(getApplicationContext(), NumbersActivity.class);
                startActivity(intent);
            }
        });
    }

    private void openFamily() {
        TextView family = (TextView) findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Toast(getApplicationContext()).makeText(getApplicationContext(), "List all Family memebers", Toast.LENGTH_SHORT).show();;
                Intent intent = new Intent(getApplicationContext(), FamilymembersActivity.class);
                startActivity(intent);
            }
        });
    }

    private void openColors() {
        TextView colors = (TextView) findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Toast(getApplicationContext()).makeText(getApplicationContext(), "List all colors", Toast.LENGTH_SHORT).show();;
                Intent intent = new Intent(getApplicationContext(), ColorActivity.class);
                startActivity(intent);
            }
        });
    }

    private void openPhrases() {
        TextView phrases = (TextView) findViewById(R.id.phrases);
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Toast(getApplicationContext()).makeText(getApplicationContext(), "List all phrases", Toast.LENGTH_SHORT).show();;
                Intent intent = new Intent(getApplicationContext(), PhrasesActivity.class);
                startActivity(intent);
            }
        });
    }
*/
}
